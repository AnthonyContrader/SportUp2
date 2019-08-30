<?php

namespace App\Repository;

use App\Entity\Allenamenti;
use Doctrine\Bundle\DoctrineBundle\Repository\ServiceEntityRepository;
use Symfony\Bridge\Doctrine\RegistryInterface;

/**
 * @method Allenamenti|null find($id, $lockMode = null, $lockVersion = null)
 * @method Allenamenti|null findOneBy(array $criteria, array $orderBy = null)
 * @method Allenamenti[]    findAll()
 * @method Allenamenti[]    findBy(array $criteria, array $orderBy = null, $limit = null, $offset = null)
 */
class AllenamentiRepository extends ServiceEntityRepository
{
    public function __construct(RegistryInterface $registry)
    {
        parent::__construct($registry, Allenamenti::class);
    }

    /*
    public function findBySomething($value)
    {
        return $this->createQueryBuilder('a')
            ->where('a.something = :value')->setParameter('value', $value)
            ->orderBy('a.id', 'ASC')
            ->setMaxResults(10)
            ->getQuery()
            ->getResult()
        ;
    }
    */
}
