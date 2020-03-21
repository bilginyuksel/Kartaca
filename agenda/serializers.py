from rest_framework import serializers
from .models import Post



# Maybe HyperLinkedSerializer is better than ModelSerializer
# i don't know now. But it can be.
class AgendaSerializer(serializers.ModelSerializer):
    MESSAGE_TYPE = 'agenda'
    VERSION = 1
    KEY_FIELD = 'id'

    class Meta:
        model = Post
        fields = ('id','note', 'place', 'created_by')


