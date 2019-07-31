using Microsoft.EntityFrameworkCore;
using SportUp.DBContext;
using SportUp.Models;
using SportUp.Repository;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;



namespace Sportup.Repository
{
    public class TrainerRepository : ITrainerRepository
    {
        private readonly PlayerContext _dbContext;
        public TrainerRepository(PlayerContext dbContext)
        {
            _dbContext = dbContext;
        }
        public TrainerRepository trainerRepository;
        //public PagamentoAcController pagamentoAcController;

        public void DeletePlayer(int idPlayer)
        {
            var player = _dbContext.Players.Find(idPlayer);
            _dbContext.Players.Remove(player);
            save();
        }

        public Player GetPlayerByIdPlayer(int idPlayer)
        {
            
            return _dbContext.Players.Find(idPlayer);
        }

        public IEnumerable<Player> GetPlayers()
        {
            
            return _dbContext.Players.ToList();
        }

        public void InsertPlayer(Player player)
        {
            _dbContext.Add(player);
            save();
        }

        public void save()
        {
            _dbContext.SaveChanges();
        }

        public void UpdatePlayer(Player player)
        {
            _dbContext.Entry(player).State = EntityState.Modified;
            save();
        }
        

        
    }
}

