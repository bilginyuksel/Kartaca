from rest_framework import serializers
from .models import Post, LogPost, User


class UserSerializer(serializers.ModelSerializer):
    
    class Meta:
        model = User
        exclude = ('is_superuser', 'password', 'is_staff', 'is_active', 'groups',
         'user_permissions', 'last_login', 'date_joined', 'id')

# Agenda serializer for API
class AgendaSerializer(serializers.ModelSerializer):
    MESSAGE_TYPE = 'agenda'
    VERSION = 1
    KEY_FIELD = 'id'

    created_by = UserSerializer()
    
    class Meta:
        model = Post
        fields = ('id','title', 'note', 'image_url', 'place', 'created_by', 'created_time')

# Agenda log serializer.
# Serialize agenda logs and send via kafka.
class AgendaLogSerializer(serializers.ModelSerializer):
    MESSAGE_TYPE = 'agenda_log'
    VERSION = 1
    KEY_FIELD = 'id'

    viewed_by = UserSerializer()
    post = AgendaSerializer()

    class Meta:
        model = LogPost
        fields = ('id', 'post', 'viewed_by', 'viewed_time')