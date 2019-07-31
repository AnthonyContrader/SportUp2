using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Cors;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;

using ActionResult = Microsoft.AspNetCore.Mvc.ActionResult;
using ControllerBase = Microsoft.AspNetCore.Mvc.ControllerBase;
using RouteAttribute = Microsoft.AspNetCore.Mvc.RouteAttribute;
using HttpGetAttribute = Microsoft.AspNetCore.Mvc.HttpGetAttribute;
using HttpDeleteAttribute = Microsoft.AspNetCore.Mvc.HttpDeleteAttribute;
using HttpPutAttribute = Microsoft.AspNetCore.Mvc.HttpPutAttribute;
using HttpPostAttribute = Microsoft.AspNetCore.Mvc.HttpPostAttribute;
using SportUp.Repository;
using System.Transactions;
using SportUp.Models;

namespace SportUp.Controllers
{
    [EnableCors("AllowOrigin")]
    [Route("api/[controller]")]
    [ApiController]
    public class TrainerController : ControllerBase
    {
        
        private readonly ITrainerRepository _trainerRepository;
        public TrainerController(ITrainerRepository trainerRepository)
        {
            _trainerRepository = trainerRepository;
        }
        // GET: api/Trainer
        [HttpGet]
        public IActionResult Get()
        {
            var player = _trainerRepository.GetPlayers();
            return new OkObjectResult(player);
        }

        // GET: api/Trainer/5
        [HttpGet("{id}", Name = "Get")]
        public IActionResult Get(int id)
        {
            var player = _trainerRepository.GetPlayerByIdPlayer(id);
            return new OkObjectResult(player);
        }

        // POST: api/Trainer
        [HttpPost]
        public IActionResult Post([FromBody] Player player)
        {
            using (var scope = new TransactionScope())
            {

                // Pagamento pagamento = PagamentoConverter.convertToPagamento(pagamentoDTO);

                _trainerRepository.InsertPlayer(player);

                scope.Complete();
                return CreatedAtAction(nameof(Get), new { id = player.idPlayer }, player);
            }
        }

        // PUT: api/Trainer/5
        [HttpPut("{id}")]
        public IActionResult Put([FromBody] Player player)
        {
            if (player != null)
            {
                using (var scope = new TransactionScope())
                {
                    _trainerRepository.UpdatePlayer(player);
                    scope.Complete();
                    return new OkResult();
                }
            }
            return new NoContentResult();
        }

        // DELETE: api/ApiWithActions/5
        [HttpDelete("{id}")]
        public IActionResult Delete(int id)
        {
            _trainerRepository.DeletePlayer(id);
            return new OkResult();
        }
    }
}
