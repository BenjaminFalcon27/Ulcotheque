<template>
<div>
    <div class="row">
        <div class="col-12">
            <Indicateurs :data="this.data && this.data.indicateurs"/>
        </div>
    </div>
    <div class="row">
        <div class="col-8">
            <div class="liste-livres">
                <table class="table table-striped">
                <thead class="thead-dark">
                    <tr>
                        <th scope="col">Livre</th>
                        <th scope="col">Auteur</th>
                        <th scope="col">Genre</th>
                        <th scope="col">Actions</th>
                    </tr>
                </thead>
                <tbody v-if="this.data && this.data.livres">
                    <Livre v-for="livre in data.livres" :key="livre.id" :data="livre" :isHomePage="true" />
                </tbody>
                </table>
            </div>
        </div>
        <div class="col-4">
            <div v-if="this.data && this.data.datasGraph" class="graph-genres">
                <PieChart :width="300" :height="300" :data="this.data.datasGraph" />
            </div>
            <div v-if="this.data && this.data.genres" class="nombre-genres">
                <div v-for="(value, name) in this.data.genres" :key="name" class="genre">
                    <span>{{name}} {{ value}}</span>
                </div>
            </div>
        </div>
    </div>
</div>
</template>
<script>
import Indicateurs from '../components/Indicateurs.vue'
import Livre from '../components/Livre.vue'
import PieChart from '../components/PieChart.vue'
import { URI } from '../env'
export default {
  components: { 
      Indicateurs, 
      Livre,
      PieChart
      },
  name: 'MainScreen',
  data () {
  return {
    data : null
    }
  },

  mounted () {
    this.axios.get(URI + 'home/').then((response) => {
        this.data = response.data
    }).catch((error) => {
        console.log(error)
        });
    },

    methods: {
        deleteLivre(id) {
            this.data.livres.splice(this.data.livres.findIndex(key => key.id === id), 1);
            this.$bvToast.toast("Le livre a bien été supprimé ! ", {
                title: 'Suppression réussie !',
                variant: 'success',
                solid: true,
                autoHideDelay: 10000,
            })
        }
    }
}


</script>
<style scoped>
.table-striped tbody tr:nth-of-type(2n+1) {
    background-color: #F5F7FA
}
.table .thead-dark th {
    background-color: #232D4B;
    border: none;
}
.table .thead-dark tr th:first-child {
    border-top-left-radius: 10px;
}
.table .thead-dark tr th:last-child {
    border-top-right-radius: 10px;
}
.liste-livres, .graph-genres, .nombre-genres {
    margin-top: 30px;
    padding: 20px;
    background: #FFFFFF 0% 0% no-repeat padding-box;
    box-shadow: 0px 2px 6px #0000001A;
    border-radius: 10px;
    opacity: 1;
}
.liste-livres, .graph-genres {
    display: flex;
}
.genre {
    border-bottom : 1px solid #CCC;
}
</style>
