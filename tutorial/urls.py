"""tutorial URL Configuration

The `urlpatterns` list routes URLs to views. For more information please see:
    https://docs.djangoproject.com/en/2.2/topics/http/urls/
Examples:
Function views
    1. Add an import:  from my_app import views
    2. Add a URL to urlpatterns:  path('', views.home, name='home')
Class-based views
    1. Add an import:  from other_app.views import Home
    2. Add a URL to urlpatterns:  path('', Home.as_view(), name='home')
Including another URLconf
    1. Import the include() function: from django.urls import include, path
    2. Add a URL to urlpatterns:  path('blog/', include('blog.urls'))
"""
from django.conf.urls import url, include

from django.contrib.auth.models import User,Group

from rest_framework import routers, serializers, viewsets

from django.contrib import admin
from snippets.models import Snippet
from snippets.models import Prova 



# Serializers define the API representation.

class UserSerializer(serializers.HyperlinkedModelSerializer):

    class Meta:

        model = User

        fields = ['url', 'username', 'email', 'is_staff']


class SnippetSerializer(serializers.HyperlinkedModelSerializer):
    class Meta:

        model = Snippet

        fields = ['url', 'created', 'title', 'code', 'linenos', 'language', 'style' ]


class ProvaSerializer(serializers.HyperlinkedModelSerializer):
    class Meta:

        model = Prova

        fields = ['url', 'libro', 'trama', 'lingua' ]



class GroupSerializer(serializers.HyperlinkedModelSerializer):

    class Meta:

        model = Group

        fields = ['url', 'name']



      

        

# ViewSets define the view behavior.

class UserViewSet(viewsets.ModelViewSet):

    queryset = User.objects.all()

    serializer_class = UserSerializer

class SnippetViewSet(viewsets.ModelViewSet):
    queryset = Snippet.objects.all()

    serializer_class = SnippetSerializer


class ProvaViewSet(viewsets.ModelViewSet):
    queryset = Prova.objects.all()

    serializer_class = ProvaSerializer

class GroupViewSet(viewsets.ModelViewSet):

    queryset = Group.objects.all()

    serializer_class = GroupSerializer



 



# Routers provide an easy way of automatically determining the URL conf.

router = routers.DefaultRouter()

router.register(r'users', UserViewSet)

router.register(r'groups', GroupViewSet)

router.register(r'snippet', SnippetViewSet)

router.register(r'prova', ProvaViewSet)





urlpatterns = [

    url(r'admin/', admin.site.urls),

    url(r'^api-auth/', include('rest_framework.urls',namespace='rest_framework')),

    url(r'^api/', include (router.urls)),

]