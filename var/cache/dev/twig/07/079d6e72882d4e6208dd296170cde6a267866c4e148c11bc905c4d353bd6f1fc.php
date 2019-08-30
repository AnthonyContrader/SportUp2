<?php

/* allenamenti/index.html.twig */
class __TwigTemplate_a872f3bc90214858419ec263d91694aa3dc6af75495acfe6bc73b121cc0883b6 extends Twig_Template
{
    private $source;

    public function __construct(Twig_Environment $env)
    {
        parent::__construct($env);

        $this->source = $this->getSourceContext();

        // line 1
        $this->parent = $this->loadTemplate("base.html.twig", "allenamenti/index.html.twig", 1);
        $this->blocks = array(
            'title' => array($this, 'block_title'),
            'body' => array($this, 'block_body'),
            'javascripts' => array($this, 'block_javascripts'),
        );
    }

    protected function doGetParent(array $context)
    {
        return "base.html.twig";
    }

    protected function doDisplay(array $context, array $blocks = array())
    {
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02 = $this->extensions["Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension"];
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->enter($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof = new Twig_Profiler_Profile($this->getTemplateName(), "template", "allenamenti/index.html.twig"));

        $this->parent->display($context, array_merge($this->blocks, $blocks));
        
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->leave($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof);

    }

    // line 3
    public function block_title($context, array $blocks = array())
    {
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02 = $this->extensions["Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension"];
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->enter($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof = new Twig_Profiler_Profile($this->getTemplateName(), "block", "title"));

        echo " allenamenti
";
        
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->leave($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof);

    }

    // line 6
    public function block_body($context, array $blocks = array())
    {
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02 = $this->extensions["Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension"];
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->enter($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof = new Twig_Profiler_Profile($this->getTemplateName(), "block", "body"));

        // line 7
        echo "    ";
        if ((isset($context["allenamenti"]) || array_key_exists("allenamenti", $context) ? $context["allenamenti"] : (function () { throw new Twig_Error_Runtime('Variable "allenamenti" does not exist.', 7, $this->source); })())) {
            // line 8
            echo "        <table class=\"table table-striped\" id=\"allenamenti\">
            <thead>
                <tr>
                    <th>Allenamenti Title</th>
                    <th>Category</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                ";
            // line 17
            $context['_parent'] = $context;
            $context['_seq'] = twig_ensure_traversable($context["allenamenti"]);
            foreach ($context['_seq'] as $context["_key"] => $context["allenamenti"]) {
                // line 18
                echo "                    <tr>
                        <td>";
                // line 19
                echo twig_escape_filter($this->env, twig_get_attribute($this->env, $this->source, $context["allenamenti"], "allenamento", array()), "html", null, true);
                echo "</td>
                        <td>";
                // line 20
                echo twig_escape_filter($this->env, twig_get_attribute($this->env, $this->source, $context["allenamenti"], "info", array()), "html", null, true);
                echo "</td>
                        <td>
                            <a class=\"btn btn-dark\" href=\"/allenamenti/";
                // line 22
                echo twig_escape_filter($this->env, twig_get_attribute($this->env, $this->source, $context["allenamenti"], "id", array()), "html", null, true);
                echo "\">Show</a>
                            <a class=\"btn btn-light\" href=\"/allenamenti/edit/";
                // line 23
                echo twig_escape_filter($this->env, twig_get_attribute($this->env, $this->source, $context["allenamenti"], "id", array()), "html", null, true);
                echo "\">Edit</a>
                            <a href=\"#\" class=\"btn btn-danger delete-allenamenti\" data-id=\"";
                // line 24
                echo twig_escape_filter($this->env, twig_get_attribute($this->env, $this->source, $context["allenamenti"], "id", array()), "html", null, true);
                echo "\">Delete</a>
                        </td>
                    </tr>
                ";
            }
            $_parent = $context['_parent'];
            unset($context['_seq'], $context['_iterated'], $context['_key'], $context['allenamenti'], $context['_parent'], $context['loop']);
            $context = array_intersect_key($context, $_parent) + $_parent;
            // line 28
            echo "            </tbody>
        </table>
    ";
        } else {
            // line 31
            echo "        <p>Non ci sono allenamenti </p>
    ";
        }
        
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->leave($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof);

    }

    // line 35
    public function block_javascripts($context, array $blocks = array())
    {
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02 = $this->extensions["Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension"];
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->enter($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof = new Twig_Profiler_Profile($this->getTemplateName(), "block", "javascripts"));

        // line 36
        echo "    <script src=\"/js/main.js\"></script>
";
        
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->leave($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof);

    }

    public function getTemplateName()
    {
        return "allenamenti/index.html.twig";
    }

    public function isTraitable()
    {
        return false;
    }

    public function getDebugInfo()
    {
        return array (  127 => 36,  121 => 35,  112 => 31,  107 => 28,  97 => 24,  93 => 23,  89 => 22,  84 => 20,  80 => 19,  77 => 18,  73 => 17,  62 => 8,  59 => 7,  53 => 6,  40 => 3,  15 => 1,);
    }

    public function getSourceContext()
    {
        return new Twig_Source("{% extends 'base.html.twig' %}

{% block title %} allenamenti
{% endblock %}

{% block body %}
    {% if allenamenti %}
        <table class=\"table table-striped\" id=\"allenamenti\">
            <thead>
                <tr>
                    <th>Allenamenti Title</th>
                    <th>Category</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                {% for allenamenti in allenamenti %}
                    <tr>
                        <td>{{ allenamenti.allenamento }}</td>
                        <td>{{ allenamenti.info }}</td>
                        <td>
                            <a class=\"btn btn-dark\" href=\"/allenamenti/{{ allenamenti.id }}\">Show</a>
                            <a class=\"btn btn-light\" href=\"/allenamenti/edit/{{ allenamenti.id }}\">Edit</a>
                            <a href=\"#\" class=\"btn btn-danger delete-allenamenti\" data-id=\"{{ allenamenti.id }}\">Delete</a>
                        </td>
                    </tr>
                {% endfor %}
            </tbody>
        </table>
    {% else %}
        <p>Non ci sono allenamenti </p>
    {% endif %}
{% endblock %}

{% block javascripts %}
    <script src=\"/js/main.js\"></script>
{% endblock %}
", "allenamenti/index.html.twig", "C:\\xampp\\htdocs\\samplephprest\\templates\\allenamenti\\index.html.twig");
    }
}
