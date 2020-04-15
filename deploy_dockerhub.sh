#!/bin/sh
echo "$DOCKER_PASSWORD" | docker login  -u "$DOCKER_USERNAME" --password-stdin

if [ "$TRAVIS_BRANCH" = "master" ]; then
    TAG="latest"
else
    TAG="$TRAVIS_BRANCH"
fi
docker build -f Dockerfile -t docker.io/$TRAVIS_REPO_SLUG:$TAG .
docker push docker.io/$TRAVIS_REPO_SLUG:$TAG