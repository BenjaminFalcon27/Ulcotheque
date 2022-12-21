<template>
    <div class="details-livre" v-if="this.data">
        <h1>{{this.data.nom}}</h1>
        <span class="d-block"><b>Editeur:</b> {{this.data.editeur}}</span>
        <span class="d-block"><b>Date de parution:</b> {{this.data.dateParution}}</span>
        <span class="d-block"><b>Lieu de parution:</b> {{this.data.lieuParution}}</span>
        <span class="d-block"><b>Nombre de pages:</b> {{this.data.nbPages}}</span>
        <span class="d-block"><b>Genre:</b> {{this.data.genre}}</span>
        <span v-if="this.data.auteur" class="d-block"><b>Auteur:</b> {{this.data.auteur.prenom}} {{this.data.auteur.nom}}</span>
    </div>
</template>
<script>
import { URI } from './../env'
export default {
  name: 'LivreDetails',
  data () {
  return {
    data: null
    }
  },

mounted () {
this.axios.get(URI + 'livres/'+ this.$route.params.id).then((response) => {
    this.data = response.data
}).catch((error) => {
    console.log(typeof(error))
  });
}
}
</script>
<style scoped>
.details-livre {
    margin-top: 30px;
    padding: 20px;
    background: #FFFFFF 0% 0% no-repeat padding-box;
    box-shadow: 0px 2px 6px #0000001A;
    border-radius: 10px;
    opacity: 1;
}
</style>
