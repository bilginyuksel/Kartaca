
# base image
FROM node:10.15.2

RUN mkdir /angular
# set working directory
WORKDIR /angular
ADD . /angular/



# install and cache app dependencies
RUN npm install
RUN npm install -g @angular/cli@
RUN npm install --save-dev webpack
RUN npm install --save-dev webpack-dev-server
