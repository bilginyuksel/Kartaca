# The first instruction is what image we want to base our container on
# So it is python runtime because we're developing django app.
FROM python:3.7.5

# The environment variable ensures that the python output is set straight
# to the terminal with out buffering it first
ENV PYTHONUNBUFFERED 1

# create root directory for our project in the container
RUN mkdir /rest_service

# set the working directory to rest_service
WORKDIR /rest_service

# Copy the current directory contents into the container at /rest_service
ADD . /rest_service/

# Install any needed packages specified in requirements.txt
RUN pip install -r requirements.txt
