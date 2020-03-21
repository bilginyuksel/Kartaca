from django.shortcuts import render
from rest_framework import viewsets
from rest_framework.response import Response
from .models import Post, User
from .serializers import AgendaSerializer
from kafka import KafkaProducer

class AgendaViewSet(viewsets.ModelViewSet):
    queryset = Post.objects.all()
    serializer_class = AgendaSerializer


    def create(self, request, *args, **kwargs):
        """
        Kafka operations here. When we create data we have to send it
        via pipe. This python application should be the producer.
        """

        return super().create(request, *args, **kwargs)
