from rest_framework import serializers
from .models import Post



# Maybe HyperLinkedSerializer is better than ModelSerializer
# i don't know now. But it can be.
class AgendaSerializer(serializers.ModelSerializer):
    
    class Meta:
        model = Post
        fields = ('note', 'place', 'created_by')


