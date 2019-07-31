using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Threading.Tasks;

namespace SportUp.Models
{
    public class Player
    {
        [Key]
        
        public int idPlayer { get; set; } 
        public string nome { get; set; }

        public string cognome { get; set; }
        [ForeignKey("Trainer")]
        public int idTrainer { get; set; }

        public Player(int idPlayer, string nome, string cognome, int idTrainer)
        {
            this.idPlayer = idPlayer;
            this.nome = nome;
            this.cognome = cognome;
            this.idTrainer = idTrainer;
        }
    }
}
