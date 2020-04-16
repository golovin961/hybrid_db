#!/bin/sh
if [ "$TRAVIS_BRANCH" = "master" ]; then
    TAG="latest"
else
    TAG="$TRAVIS_BRANCH"
fi
echo "$DOCKER_PASSWORD" | docker login -u "$DOCKER_USERNAME" --password-stdin
docker build -t $TRAVIS_REPO_SLUG:$TAG .
docker push $TRAVIS_REPO_SLUG