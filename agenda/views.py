from django.shortcuts import render
from rest_framework import viewsets
from rest_framework.response import Response
from .models import Post, User
from .serializers import AgendaSerializer
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
        test = Post(note="new messageex", created_by = request.user)
        producer = Producer('test', AgendaSerializer)
        producer.send(test)
        

        return super().list(request, *args, **kwargs)
