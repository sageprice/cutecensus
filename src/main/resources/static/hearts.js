// Set up the mouse to draw hearts following the cursor.
document.addEventListener('mousemove', (e) => {
  if (Date.now() % 15 == 0) {
    const heart = document.createElement('div');
    heart.className = 'heart';
    heart.style.left = `${e.pageX}px`;
    heart.style.top = `${e.pageY+15}px`;

    document.body.appendChild(heart);

    // Remove the heart after animation ends (3 seconds for this example)
    setTimeout(() => {
      heart.remove();
    }, 1500);
  }
});