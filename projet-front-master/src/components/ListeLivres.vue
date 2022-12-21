<template>
    <div class="liste-livres">
                <table class="table table-striped">
                <thead class="thead-dark">
                    <tr>
                        <th scope="col">Livre</th>
                        <th scope="col">Auteur</th>
                        <th scope="col">Genre</th>
                        <th scope="col">Editeur</th>
                        <th scope="col">Nombre de pages</th>
                        <th scope="col">Lieu de parution</th>
                    </tr>
                </thead>
                <tbody v-if="this.data">
                    <Livre v-for="livre in data" :key="livre.id" :data="livre" :isHomePage="false" />
                </tbody>
                </table>
            </div>
</template>
<script>
import Livre from '../components/Livre.vue'
import { URI} from '../env'
export default {
  components: { 
      Livre
    },
  name: 'ListeLivres',
  data () {
  return {
    data : null
    }
  },

  mounted () {
      const realURI = this.$route.params.genre ?  URI + "livres?genre=" + this.$route.params.genre : URI + "livres";
    this.axios.get(realURI).then((response) => {
        this.data = response.data
    }).catch((error) => {
        console.log(error)
        });
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
.liste-livres {
    margin-top: 30px;
    padding: 20px;
    background: #FFFFFF 0% 0% no-repeat padding-box;
    box-shadow: 0px 2px 6px #0000001A;
    border-radius: 10px;
    opacity: 1;
    display: flex;
}
</style>