from rest_framework import serializers
from snippets.models import Dieta, LANGUAGE_CHOICES, STYLE_CHOICES


class DietaSerializer(serializers.Serializer):
    id = serializers.IntegerField(read_only=True)
    lun = serializers.CharField(style={'base_template': 'textarea.html'})
    mar = serializers.CharField(style={'base_template': 'textarea.html'})
    mer = serializers.CharField(style={'base_template': 'textarea.html'})
    gio = serializers.CharField(style={'base_template': 'textarea.html'})
    ven = serializers.CharField(style={'base_template': 'textarea.html'})

    def create(self, validated_data):
        """
        Create and return a new `Snippet` instance, given the validated data.
        """
        return Dieta.objects.create(**validated_data)

    def update(self, instance, validated_data):
        """
        Update and return an existing `Snippet` instance, given the validated data.
        """
        instance.lun = validated_data.get('lun', instance.lun)
        instance.mar = validated_data.get('mar', instance.mar)
        instance.mer = validated_data.get('mer', instance.mer)
        instance.gio = validated_data.get('gio', instance.gio)
        instance.ven = validated_data.get('ven', instance.ven)
        instance.sab = validated_data.get('sab', instance.sab)
        instance.save()
        return instance