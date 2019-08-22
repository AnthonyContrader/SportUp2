from django.urls import path
from snippets import views

urlpatterns = [
    path('diete/', views.dieta_list),
    path('diete/<int:pk>/', views.dieta_detail),
]