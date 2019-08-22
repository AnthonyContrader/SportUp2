from django.contrib import admin
from .models import Dieta
from .models import Allenamento 
from .models import Utenti

admin.site.register(Dieta)
admin.site.register(Allenamento)
admin.site.register(Utenti)

# Register your models here.
