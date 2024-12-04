# Cute Census

Hobby project to rank cute animals. Scoring based on head-to-head comparisons using the Elo rating system.

## Deployment

Runnable locally with gradle, or in a container with docker.

Current approach: build JAR, and run on AWS using ElasticBeanstalk. Gotchas during setup:
- AWS doesn't allow services to create IAM roles that control other services any more, so I had to manually create the EC2 IAM config.
- Have to set the SERVER_PORT env variable in EB to 5000 to match that platform's expected port ([link](https://guides.grails.org/grails-elasticbeanstalk/guide/index.html#:~:text=By%20default%2C%20Grails%20applications%20will,will%20listen%20on%20port%205000)). 
