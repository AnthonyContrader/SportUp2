<?php

use Symfony\Component\DependencyInjection\Argument\RewindableGenerator;

// This file has been auto-generated by the Symfony Dependency Injection Component for internal use.
// Returns the public 'doctrine.orm.default_entity_manager' shared service.

include_once $this->targetDirs[3].'\\vendor\\doctrine\\cache\\lib\\Doctrine\\Common\\Cache\\Cache.php';
include_once $this->targetDirs[3].'\\vendor\\doctrine\\cache\\lib\\Doctrine\\Common\\Cache\\FlushableCache.php';
include_once $this->targetDirs[3].'\\vendor\\doctrine\\cache\\lib\\Doctrine\\Common\\Cache\\ClearableCache.php';
include_once $this->targetDirs[3].'\\vendor\\doctrine\\cache\\lib\\Doctrine\\Common\\Cache\\MultiGetCache.php';
include_once $this->targetDirs[3].'\\vendor\\doctrine\\cache\\lib\\Doctrine\\Common\\Cache\\MultiDeleteCache.php';
include_once $this->targetDirs[3].'\\vendor\\doctrine\\cache\\lib\\Doctrine\\Common\\Cache\\MultiPutCache.php';
include_once $this->targetDirs[3].'\\vendor\\doctrine\\cache\\lib\\Doctrine\\Common\\Cache\\MultiOperationCache.php';
include_once $this->targetDirs[3].'\\vendor\\doctrine\\cache\\lib\\Doctrine\\Common\\Cache\\CacheProvider.php';
include_once $this->targetDirs[3].'\\vendor\\doctrine\\cache\\lib\\Doctrine\\Common\\Cache\\ArrayCache.php';
include_once $this->targetDirs[3].'\\vendor\\doctrine\\common\\lib\\Doctrine\\Common\\Persistence\\Mapping\\Driver\\MappingDriver.php';
include_once $this->targetDirs[3].'\\vendor\\doctrine\\common\\lib\\Doctrine\\Common\\Persistence\\Mapping\\Driver\\AnnotationDriver.php';
include_once $this->targetDirs[3].'\\vendor\\doctrine\\orm\\lib\\Doctrine\\ORM\\Mapping\\Driver\\AnnotationDriver.php';
include_once $this->targetDirs[3].'\\vendor\\doctrine\\common\\lib\\Doctrine\\Common\\Persistence\\Mapping\\Driver\\MappingDriverChain.php';
include_once $this->targetDirs[3].'\\vendor\\doctrine\\orm\\lib\\Doctrine\\ORM\\Mapping\\NamingStrategy.php';
include_once $this->targetDirs[3].'\\vendor\\doctrine\\orm\\lib\\Doctrine\\ORM\\Mapping\\UnderscoreNamingStrategy.php';
include_once $this->targetDirs[3].'\\vendor\\doctrine\\orm\\lib\\Doctrine\\ORM\\Mapping\\QuoteStrategy.php';
include_once $this->targetDirs[3].'\\vendor\\doctrine\\orm\\lib\\Doctrine\\ORM\\Mapping\\DefaultQuoteStrategy.php';
include_once $this->targetDirs[3].'\\vendor\\doctrine\\orm\\lib\\Doctrine\\ORM\\Mapping\\EntityListenerResolver.php';
include_once $this->targetDirs[3].'\\vendor\\doctrine\\doctrine-bundle\\Mapping\\EntityListenerServiceResolver.php';
include_once $this->targetDirs[3].'\\vendor\\doctrine\\doctrine-bundle\\Mapping\\ContainerAwareEntityListenerResolver.php';
include_once $this->targetDirs[3].'\\vendor\\doctrine\\orm\\lib\\Doctrine\\ORM\\Repository\\RepositoryFactory.php';
include_once $this->targetDirs[3].'\\vendor\\doctrine\\doctrine-bundle\\Repository\\ContainerRepositoryFactory.php';
include_once $this->targetDirs[3].'\\vendor\\doctrine\\dbal\\lib\\Doctrine\\DBAL\\Configuration.php';
include_once $this->targetDirs[3].'\\vendor\\doctrine\\orm\\lib\\Doctrine\\ORM\\Configuration.php';
include_once $this->targetDirs[3].'\\vendor\\doctrine\\doctrine-bundle\\ManagerConfigurator.php';
include_once $this->targetDirs[3].'\\vendor\\doctrine\\common\\lib\\Doctrine\\Common\\Persistence\\ObjectManager.php';
include_once $this->targetDirs[3].'\\vendor\\doctrine\\orm\\lib\\Doctrine\\ORM\\EntityManagerInterface.php';
include_once $this->targetDirs[3].'\\vendor\\doctrine\\orm\\lib\\Doctrine\\ORM\\EntityManager.php';

$a = new \Doctrine\Common\Cache\ArrayCache();
$a->setNamespace('sf_orm_default_377bade8c24c7158c58d324684342dc725b993ae244e6d7effea6456bb87f7bb');

$b = new \Doctrine\Common\Cache\ArrayCache();
$b->setNamespace('sf_orm_default_377bade8c24c7158c58d324684342dc725b993ae244e6d7effea6456bb87f7bb');

$c = new \Doctrine\Common\Cache\ArrayCache();
$c->setNamespace('sf_orm_default_377bade8c24c7158c58d324684342dc725b993ae244e6d7effea6456bb87f7bb');

$d = new \Doctrine\Common\Persistence\Mapping\Driver\MappingDriverChain();
$d->addDriver(new \Doctrine\ORM\Mapping\Driver\AnnotationDriver(($this->privates['annotations.cached_reader'] ?? $this->getAnnotations_CachedReaderService()), array(0 => ($this->targetDirs[3].'\\src\\Entity'))), 'App\\Entity');

$e = new \Doctrine\ORM\Configuration();
$e->setEntityNamespaces(array('App' => 'App\\Entity'));
$e->setMetadataCacheImpl($a);
$e->setQueryCacheImpl($b);
$e->setResultCacheImpl($c);
$e->setMetadataDriverImpl($d);
$e->setProxyDir(($this->targetDirs[0].'/doctrine/orm/Proxies'));
$e->setProxyNamespace('Proxies');
$e->setAutoGenerateProxyClasses(true);
$e->setClassMetadataFactoryName('Doctrine\\ORM\\Mapping\\ClassMetadataFactory');
$e->setDefaultRepositoryClassName('Doctrine\\ORM\\EntityRepository');
$e->setNamingStrategy(new \Doctrine\ORM\Mapping\UnderscoreNamingStrategy());
$e->setQuoteStrategy(new \Doctrine\ORM\Mapping\DefaultQuoteStrategy());
$e->setEntityListenerResolver(new \Doctrine\Bundle\DoctrineBundle\Mapping\ContainerAwareEntityListenerResolver($this));
$e->setRepositoryFactory(new \Doctrine\Bundle\DoctrineBundle\Repository\ContainerRepositoryFactory(new \Symfony\Component\DependencyInjection\ServiceLocator(array('App\\Repository\\AllenamentiRepository' => function () {
    return ($this->privates['App\Repository\AllenamentiRepository'] ?? $this->load(__DIR__.'/getAllenamentiRepositoryService.php'));
}, 'App\\Repository\\ArticleRepository' => function () {
    return ($this->privates['App\Repository\ArticleRepository'] ?? $this->load(__DIR__.'/getArticleRepositoryService.php'));
}, 'App\\Repository\\PlayerRepository' => function () {
    return ($this->privates['App\Repository\PlayerRepository'] ?? $this->load(__DIR__.'/getPlayerRepositoryService.php'));
}, 'App\\Repository\\UserRepository' => function () {
    return ($this->privates['App\Repository\UserRepository'] ?? $this->load(__DIR__.'/getUserRepositoryService.php'));
}))));

$this->services['doctrine.orm.default_entity_manager'] = $instance = \Doctrine\ORM\EntityManager::create(($this->services['doctrine.dbal.default_connection'] ?? $this->load(__DIR__.'/getDoctrine_Dbal_DefaultConnectionService.php')), $e);

(new \Doctrine\Bundle\DoctrineBundle\ManagerConfigurator(array(), array()))->configure($instance);

return $instance;
