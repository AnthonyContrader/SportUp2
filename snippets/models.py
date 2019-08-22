from django.db import models
from pygments.lexers import get_all_lexers
from pygments.styles import get_all_styles

LEXERS = [item for item in get_all_lexers() if item[1]]
LANGUAGE_CHOICES = sorted([(item[1][0], item[0]) for item in LEXERS])
STYLE_CHOICES = sorted([(item, item) for item in get_all_styles()])


class Dieta(models.Model):
    lun = models.TextField()
    mar = models.TextField()
    mer = models.TextField()
    gio = models.TextField()
    ven = models.TextField()
    sab = models.TextField()

   

    def __str__(self):
        return self.lun

class Allenamento(models.Model):
    lun = models.TextField()
    mar = models.TextField()
    mer = models.TextField()
    gio = models.TextField()
    ven = models.TextField()
    sab = models.TextField()

    def __str__(self):
        return self.lun

class Utenti(models.Model):
    nome = models.TextField()
    cognome = models.TextField()
    ruolo = models.TextField()

    def __str__(self):
        return self.nome




    
