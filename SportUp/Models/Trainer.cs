using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace SportUp.Models
{
    public class Trainer
    {
        [Key]
        public int idTrainer { get; set; }
        public string username { get; set; }
        public string password { get; set; }

        public Trainer(int idTrainer, string username, string password)
        {
            this.idTrainer = idTrainer;
            this.username = username;
            this.password = password;
        }
    }
}
