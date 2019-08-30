<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * @ORM\Entity(repositoryClass="App\Repository\AllenamentiRepository")
 */
class Allenamenti
{
    /**
     * @ORM\Id()
     * @ORM\GeneratedValue()
     * @ORM\Column(type="integer")
     */
    private $id;

    /**
     * @ORM\Column(type="text", length=100)
     */
    private $allenamento;

    /**
     * @ORM\Column(type="text")
     */
    private $info;

    

    // Getters & Setters
    public function getId() {
        return $this->id;
    }

    public function getAllenamento() {
        return $this->allenamento;
    }

    public function setAllenamento($allenamento) {
        $this->allenamento = $allenamento;
    }

    public function getInfo() {
        return $this->info;
    }

    public function setInfo($info) {
        $this->info = $info;
    }

    

}
