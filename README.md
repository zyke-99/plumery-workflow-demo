# Workflow demo

## How to run the workflow demo:

Prerequisites:
1) Git
2) Docker
3) IntelliJ IDEA
4) Postman (cURL can also be used, however, this repo contains an exported postman collection)

Step 1: clone repository

Run the following:
```
git clone <repo url>
```
Then change directory by running:
```
cd plumery-workflow-demo
```
Step 2: infra setup

Run the following commands:
```
cd src/main/docker
docker-compose -f docker-compose-temporal.yml up -d
```
Step 3: running service itself

Open ‘Run anything’ in intellij and run the following command:
```
mvn clean quarkus:dev
```

The onboarding service should be up and running on localhost:8080

The Temporal UI can be accessed via a browser with URL localhost:8081

## How to go through a the whole workflow:

For these steps it's recommended to import the postman collection (under /postman directory)
for convenience

Step 1: trigger the onboarding process

This can be done by executing the `start onboarding` request via Postman. Once that is done
a response containing the onboarding ID will be returned - this onboarding ID will be used later

A new workflow should be visible in the Temporal UI (via browser, localhost:8081)

Step 2: send phone OTP to verify

For this step execute the `phone confirm` request, modifying the body beforehand with the onboarding ID fetched from the 
1st step.

Step 3: send selfie verification confirmation

For this step execute the `selfie confirm` request, modifying the body beforehand with the onboarding ID fetched from the
1st step. 