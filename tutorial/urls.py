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
from snippets.models import Dieta
from snippets.models import Allenamento 
from snippets.models import Utenti



# Serializers define the API representation.

class UserSerializer(serializers.HyperlinkedModelSerializer):

    class Meta:

        model = User

        fields = ['url', 'username', 'email', 'is_staff']


class DietaSerializer(serializers.HyperlinkedModelSerializer):
    class Meta:

        model = Dieta

        fields = ['url', 'lun', 'mar', 'mer', 'gio', 'ven', 'sab' ]


class AllenamentoSerializer(serializers.HyperlinkedModelSerializer):
    class Meta:

        model = Allenamento

        fields = ['url', 'lun', 'mar', 'mer', 'gio', 'ven', 'sab' ]

class UtentiSerializer(serializers.HyperlinkedModelSerializer):
    class Meta:

        model = Utenti

        fields = ['url', 'nome', 'cognome', 'ruolo' ]



class GroupSerializer(serializers.HyperlinkedModelSerializer):

    class Meta:

        model = Group

        fields = ['url', 'name']



      

        

# ViewSets define the view behavior.

class UserViewSet(viewsets.ModelViewSet):

    queryset = User.objects.all()

    serializer_class = UserSerializer

class DietaViewSet(viewsets.ModelViewSet):
    queryset = Dieta.objects.all()

    serializer_class = DietaSerializer


class AllenamentoViewSet(viewsets.ModelViewSet):
    queryset = Allenamento.objects.all()

    serializer_class = AllenamentoSerializer

class UtentiViewSet(viewsets.ModelViewSet):
    queryset = Utenti.objects.all()

    serializer_class = UtentiSerializer

class GroupViewSet(viewsets.ModelViewSet):

    queryset = Group.objects.all()

    serializer_class = GroupSerializer



 



# Routers provide an easy way of automatically determining the URL conf.

router = routers.DefaultRouter()

router.register(r'users', UserViewSet)

router.register(r'groups', GroupViewSet)

router.register(r'dieta', DietaViewSet)

router.register(r'allenamento', AllenamentoViewSet)

router.register(r'utenti', UtentiViewSet)





urlpatterns = [

    url(r'admin/', admin.site.urls),

    url(r'^api-auth/', include('rest_framework.urls',namespace='rest_framework')),

    url(r'^api/', include (router.urls)),

]