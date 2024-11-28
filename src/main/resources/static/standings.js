
// Register event listener for arrow keys to quick select winner.
document.addEventListener('keydown', function(event) {
  if (window.location.href.includes('head2head')) {
    if (event.key == 'ArrowLeft') {
      sendLeftWinner()
    } else if (event.key == 'ArrowRight') {
      sendRightWinner()
    }
  }
});

// Retrieve the current rankings and display them.
function getRankings() {
  fetch('http://localhost:8080/api/v1/standings')
    .then(response => {
      if (!response.ok) {
        throw new Error('Network response was not ok: ' + response);
      }
      return response.json();
    })
    .then(data => {
      // Do something with the data
      console.log(data);
      updateTable(data['standings']);
    })
    .catch(error => {
      console.error('Error:', error);
    });
}

// Updates the standings table with the current rankings from the backend.
function updateTable(standings) {
  let tableBodyDiv = document.getElementById('listbody');
  for (let i = 0; i < standings.length; i++) {
    const item = standings[i];
    const row = document.createElement("tr");
    const rankTd = document.createElement("td");
    rankTd.textContent = `${i+1}`;
    const nameTd = document.createElement("td");
    nameTd.textContent = item['name'];
    const eloTd = document.createElement("td");
    eloTd.textContent = Math.round(item['score']);
//    const winsTd = document.createElement("td");
//    const lossesTd = document.createElement("td");
//    const drawsTd = document.createElement("td");
//    newDiv.classList.add("ranking");

    row.appendChild(rankTd);
    row.appendChild(nameTd);
    row.appendChild(eloTd);
//    row.appendChild(winsTd);
//    row.appendChild(lossesTd);
//    row.appendChild(drawsTd);
//    newDiv.textContent = `${i+1}: ${item['name']} -- ${Math.round(item['score'])}`;

    tableBodyDiv.appendChild(row);
  }
}

function sendLeftWinner() {
  recordResult("left")
}

function sendRightWinner() {
  recordResult("right")
}

function sendTie() {
  recordResult("tie")
}

function recordResult(winnerDirection) {
  const left = document.getElementById("leftp").innerText
  const right = document.getElementById("rightp").innerText
  let winner = left
  let loser = right
  let isDraw = winnerDirection === "tie"
  if (winnerDirection === "right") {
    winner = right
    loser = left
  }
  console.log("Winner: " + winner)
  console.log("Loser: " + loser)
  uploadResult(`http://localhost:8080/api/v1/comparison?winner=${winner}&loser=${loser}&isDraw=${isDraw}`)
  getNewMatchup([left, right])
}

function uploadResult(endpoint) {
  fetch(endpoint,
    {
    method: 'POST'
    })
    .then(response => {
      if (!response.ok) {
        throw new Error('Network response was not ok: ' + response);
      }
      return response.json();
    })
    .then(data => {
      // Do something with the data
      console.log(data);
    })
    .catch(error => {
      console.error('Error:', error);
    });
}

function getMatchup() {
  getNewMatchup([])
}

function getNewMatchup(excludedAnimals) {
  let endpoint = `http://localhost:8080/api/v1/matchups/random`
  if (excludedAnimals.length > 0) {
    endpoint += `?except=` + excludedAnimals.join(",")
  }
  console.log(endpoint)
  fetch(endpoint)
    .then(response => {
      if (!response.ok) {
        throw new Error('Network response was not ok: ' + response);
      }
      return response.json();
    })
    .then(data => {
      // Do something with the data
      console.log(data);

      document.getElementById("leftp").innerText = data['left']['name']
      document.getElementById("leftimg").src = data['leftImage']
      document.getElementById("rightp").innerText = data['right']['name']
      document.getElementById("rightimg").src = data['rightImage']
    })
    .catch(error => {
      console.error('Error:', error);
    });
}
