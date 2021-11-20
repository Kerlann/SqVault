<template>
     <div class="wrapper">
        <div class="d-flex">
          <div class="sidebar bg-f4" id="sidebar-wrapper">
            <div class="border-info">
              <div id="pic" class="sidebar-heading border-bottom">
                <img id="imageID" src="https://minotar.net/avatar/Notch/70.png" />
                <a class="button-job" href="#">grade <br /><a class="button-info" href="#">playerName</a></a>
              </div>
            </div>
            <div class="list-group list-group-flush">
              <a className="button-f4" @click="changePage(0)"><span>Tableau de bord</span></a>
              <a className="button-f4" @click="changePage(1)"><span>Commandes</span></a>
              <a className="button-f4" @click="changePage(2)"><span>Metiers</span></a>
              <a className="button-f4" @click="changePage(3)"><span>Armes</span></a>
              <a className="button-f4" @click="changePage(4)"><span>Entities</span></a>
              <a className="button-f4" @click="changePage(5)"><span>Munitions</span></a>
              <a className="button-f4" @click="changePage(6)"><span>Nourritures</span></a>
            </div>
          </div>
          <div id="page-content-wrapper">
            <div class="navbar">
              <img src="jutify.png" width="35" height="35" />
              <a href="#">{{ page }}</a>
            </div>
            <div class="container-fluid">
             
            </div>
          </div>
        </div>
      </div>
</template>

<script>
module.exports = {
    components: [],
    data() {
        return {
            
        }
    },
    methods: {
        changePage: function(page) {
            this.page = page;
            console.log(page);
        }
    },
    props: [
        "page"
    ]
}
</script>