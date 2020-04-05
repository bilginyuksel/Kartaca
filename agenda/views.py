from django.shortcuts import render
from rest_framework import viewsets
from rest_framework.response import Response
from .models import Post, User, LogPost
from .serializers import AgendaSerializer, AgendaLogSerializer
from logpipe import Producer

class AgendaViewSet(viewsets.ModelViewSet):
    queryset = Post.objects.all()
    serializer_class = AgendaSerializer

    def retrieve(self, request, pk = None):
        """
        Instead of viewing any post requested.
        When any of these posts viewed send this viewed information to
        logger spring-boot application via kafka.
        """

        viewed_post = Post.objects.get(pk = pk) # Viewed post
        viewed_by = request.user # Viewed user

        kafka_log_post = LogPost(post = viewed_post, viewed_by = viewed_by)
        kafka_producer = Producer('sarama_topic', AgendaLogSerializer)
        kafka_producer.send(kafka_log_post)
        print(AgendaLogSerializer(kafka_log_post).data)

        return super().retrieve(request, pk)

