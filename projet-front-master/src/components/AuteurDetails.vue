<template>
    <div class="details-auteur" v-if="data">
        <h2 scope="row">{{this.data.prenom}} {{this.data.nom}}</h2>
        <span>{{this.data.dateNaissance}}</span>
        <div v-if="this.data.livres">
            <h3>Livres de l'auteur: </h3>
            <span class="d-block" v-for="livre in this.data.livres" :key="livre.id">{{livre.nom}} | {{livre.editeur}}</span>
        </div>
    </div>
</template>
<script>
import { URI } from './../env'
export default {
  name: 'AuteurDetails',
  data () {
    return {
      data: null
    }
  },

  mounted () {
    this.axios.get(URI + 'auteurs/'+ this.$route.params.id).then((response) => {
    this.data = response.data
    }).catch((error) => {
    console.log(error)
  });
}
}
</script>

<style scoped>
.details-auteur {
    margin-top: 30px;
    padding: 20px;
    background: #FFFFFF 0% 0% no-repeat padding-box;
    box-shadow: 0px 2px 6px #0000001A;
    border-radius: 10px;
    opacity: 1;
}
</style>
