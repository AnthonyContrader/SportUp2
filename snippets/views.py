from django.http import HttpResponse, JsonResponse
from django.views.decorators.csrf import csrf_exempt
from rest_framework.parsers import JSONParser
from snippets.models import Dieta
from snippets.serializers import DietaSerializer

@csrf_exempt
def dieta_list(request):
    """
    List all code snippets, or create a new snippet.
    """
    if request.method == 'GET':
        diete = Dieta.objects.all()
        serializer = DietaSerializer(diete, many=True)
        return JsonResponse(serializer.data, safe=False)

    elif request.method == 'POST':
        data = JSONParser().parse(request)
        serializer = DietaSerializer(data=data)
        if serializer.is_valid():
            serializer.save()
            return JsonResponse(serializer.data, status=201)
        return JsonResponse(serializer.errors, status=400)

@csrf_exempt
def dieta_detail(request, pk):
    """
    Retrieve, update or delete a code snippet.
    """
    try:
        dieta = Dieta.objects.get(pk=pk)
    except Dieta.DoesNotExist:
        return HttpResponse(status=404)

    if request.method == 'GET':
        serializer = DietaSerializer(dieta)
        return JsonResponse(serializer.data)

    elif request.method == 'PUT':
        data = JSONParser().parse(request)
        serializer = DietaSerializer(dieta, data=data)
        if serializer.is_valid():
            serializer.save()
            return JsonResponse(serializer.data)
        return JsonResponse(serializer.errors, status=400)

    elif request.method == 'DELETE':
        dieta.delete()
        return HttpResponse(status=204)