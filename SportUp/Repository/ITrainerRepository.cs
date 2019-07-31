using SportUp.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace SportUp.Repository
{
    public interface ITrainerRepository
    {
        IEnumerable<Player> GetPlayers();
        Player GetPlayerByIdPlayer(int idPlayer);
        void InsertPlayer(Player player);
        void DeletePlayer(int idPlayer);
        void UpdatePlayer(Player player);
        void save();
        //IEnumerable<Player> GetAllPlayer();




    }
}


