<?php

use Symfony\Component\Routing\Exception\MethodNotAllowedException;
use Symfony\Component\Routing\Exception\ResourceNotFoundException;
use Symfony\Component\Routing\RequestContext;

/**
 * This class has been auto-generated
 * by the Symfony Routing Component.
 */
class srcDevDebugProjectContainerUrlMatcher extends Symfony\Bundle\FrameworkBundle\Routing\RedirectableUrlMatcher
{
    public function __construct(RequestContext $context)
    {
        $this->context = $context;
    }

    public function match($rawPathinfo)
    {
        $allow = array();
        $pathinfo = rawurldecode($rawPathinfo);
        $trimmedPathinfo = rtrim($pathinfo, '/');
        $context = $this->context;
        $request = $this->request ?: $this->createRequest($pathinfo);
        $requestMethod = $canonicalMethod = $context->getMethod();

        if ('HEAD' === $requestMethod) {
            $canonicalMethod = 'GET';
        }

        // allenamenti_list
        if ('' === $trimmedPathinfo) {
            $ret = array (  '_controller' => 'App\\Controller\\AllenamentiController::index',  '_route' => 'allenamenti_list',);
            if ('/' === substr($pathinfo, -1)) {
                // no-op
            } elseif ('GET' !== $canonicalMethod) {
                goto not_allenamenti_list;
            } else {
                return array_replace($ret, $this->redirect($rawPathinfo.'/', 'allenamenti_list'));
            }

            if (!in_array($canonicalMethod, array('GET'))) {
                $allow = array_merge($allow, array('GET'));
                goto not_allenamenti_list;
            }

            return $ret;
        }
        not_allenamenti_list:

        if (0 === strpos($pathinfo, '/allenamenti')) {
            // new_allenamento
            if ('/allenamenti/new' === $pathinfo) {
                return array (  '_controller' => 'App\\Controller\\AllenamentiController::new',  '_route' => 'new_allenamento',);
            }

            // edit_allenamento
            if (0 === strpos($pathinfo, '/allenamenti/edit') && preg_match('#^/allenamenti/edit/(?P<id>[^/]++)$#sD', $pathinfo, $matches)) {
                return $this->mergeDefaults(array_replace($matches, array('_route' => 'edit_allenamento')), array (  '_controller' => 'App\\Controller\\AllenamentiController::edit',));
            }

            // allenamento_show
            if (preg_match('#^/allenamenti/(?P<id>[^/]++)$#sD', $pathinfo, $matches)) {
                return $this->mergeDefaults(array_replace($matches, array('_route' => 'allenamento_show')), array (  '_controller' => 'App\\Controller\\AllenamentiController::show',));
            }

            // app_allenamenti_delete
            if (0 === strpos($pathinfo, '/allenamenti/delete') && preg_match('#^/allenamenti/delete/(?P<id>[^/]++)$#sD', $pathinfo, $matches)) {
                $ret = $this->mergeDefaults(array_replace($matches, array('_route' => 'app_allenamenti_delete')), array (  '_controller' => 'App\\Controller\\AllenamentiController::delete',));
                if (!in_array($requestMethod, array('DELETE'))) {
                    $allow = array_merge($allow, array('DELETE'));
                    goto not_app_allenamenti_delete;
                }

                return $ret;
            }
            not_app_allenamenti_delete:

        }

        elseif (0 === strpos($pathinfo, '/article')) {
            // new_article
            if ('/article/new' === $pathinfo) {
                return array (  '_controller' => 'App\\Controller\\ArticleController::new',  '_route' => 'new_article',);
            }

            // edit_article
            if (0 === strpos($pathinfo, '/article/edit') && preg_match('#^/article/edit/(?P<id>[^/]++)$#sD', $pathinfo, $matches)) {
                return $this->mergeDefaults(array_replace($matches, array('_route' => 'edit_article')), array (  '_controller' => 'App\\Controller\\ArticleController::edit',));
            }

            // article_show
            if (preg_match('#^/article/(?P<id>[^/]++)$#sD', $pathinfo, $matches)) {
                return $this->mergeDefaults(array_replace($matches, array('_route' => 'article_show')), array (  '_controller' => 'App\\Controller\\ArticleController::show',));
            }

            // app_article_delete
            if (0 === strpos($pathinfo, '/article/delete') && preg_match('#^/article/delete/(?P<id>[^/]++)$#sD', $pathinfo, $matches)) {
                $ret = $this->mergeDefaults(array_replace($matches, array('_route' => 'app_article_delete')), array (  '_controller' => 'App\\Controller\\ArticleController::delete',));
                if (!in_array($requestMethod, array('DELETE'))) {
                    $allow = array_merge($allow, array('DELETE'));
                    goto not_app_article_delete;
                }

                return $ret;
            }
            not_app_article_delete:

        }

        // article_list
        if ('' === $trimmedPathinfo) {
            $ret = array (  '_controller' => 'App\\Controller\\ArticleController::index',  '_route' => 'article_list',);
            if ('/' === substr($pathinfo, -1)) {
                // no-op
            } elseif ('GET' !== $canonicalMethod) {
                goto not_article_list;
            } else {
                return array_replace($ret, $this->redirect($rawPathinfo.'/', 'article_list'));
            }

            if (!in_array($canonicalMethod, array('GET'))) {
                $allow = array_merge($allow, array('GET'));
                goto not_article_list;
            }

            return $ret;
        }
        not_article_list:

        // _twig_error_test
        if (0 === strpos($pathinfo, '/_error') && preg_match('#^/_error/(?P<code>\\d+)(?:\\.(?P<_format>[^/]++))?$#sD', $pathinfo, $matches)) {
            return $this->mergeDefaults(array_replace($matches, array('_route' => '_twig_error_test')), array (  '_controller' => 'twig.controller.preview_error:previewErrorPageAction',  '_format' => 'html',));
        }

        throw 0 < count($allow) ? new MethodNotAllowedException(array_unique($allow)) : new ResourceNotFoundException();
    }
}
