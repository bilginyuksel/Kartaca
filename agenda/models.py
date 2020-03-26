from django.db import models
from django.contrib.auth.models import User
from django.utils import timezone

class Post(models.Model):

    note = models.TextField(null = True, blank = True)
    place = models.CharField(max_length=200, null=True, blank=True)
    created_by = models.ForeignKey(User, on_delete=models.CASCADE)
    created_time = models.DateTimeField(default = timezone.now, blank=True)


class LogPost(models.Model):

    post = models.ForeignKey(Post, on_delete = models.DO_NOTHING)
    viewed_by = models.ForeignKey(User, on_delete = models.DO_NOTHING)
    viewed_time = models.DateTimeField(default = timezone.now, blank = True)
