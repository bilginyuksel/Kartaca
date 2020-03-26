from django.shortcuts import render
from rest_framework import viewsets
from rest_framework.response import Response
from .models import Post, User, LogPost
from .serializers import AgendaSerializer, AgendaLogSerializer
from logpipe import Producer

class AgendaViewSet(viewsets.ModelViewSet):
    queryset = Post.objects.all()
    serializer_class = AgendaSerializer



    def list(self, request, *args, **kwargs):
        """
        use kafka operations here. 
        By the way real operation should be when you look at the details of the
        travel agenda.
        """
        # Don't save an object to database here.
        """
        Commit changes here. I changed the data Post that we will send to KAFKA with LogPost.
        And also i changed the serializer according to LogPost.
        In this case i have to configure api details method and send the log data to kafka
        on that method (API Post Details). 
        """
        test = Post(note="new messageex", created_by = request.user)
        test2 = LogPost(post = test, viewed_by = request.user) # viewed_time will be automatically set.
        producer = Producer('test', AgendaLogSerializer)
        producer.send(test2)
        

        return super().list(request, *args, **kwargs)
