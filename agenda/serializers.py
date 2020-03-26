from rest_framework import serializers
from .models import Post, LogPost


# Agenda serializer for API
class AgendaSerializer(serializers.ModelSerializer):
    MESSAGE_TYPE = 'agenda'
    VERSION = 1
    KEY_FIELD = 'id'

    class Meta:
        model = Post
        fields = ('id','note', 'place', 'created_by')


# Agenda log serializer.
# Serialize agenda logs and send via kafka.
class AgendaLogSerializer(serializers.ModelSerializer):
    MESSAGE_TYPE = 'agenda_log'
    VERSION = 1
    KEY_FIELD = 'id'

    class Meta:
        model = LogPost
        fields = ('id', 'post', 'viewed_by', 'viewed_time')