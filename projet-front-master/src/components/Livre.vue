<template>
    <tr v-if="data">
        <th scope="row">{{this.data.nom}}</th>
        <td>
            <router-link v-if="this.data.auteur" :to="{ name: 'auteurDetails', params: {id: data.auteur.id } }">
                {{this.data.auteur.prenom}} {{this.data.auteur.nom}}
            </router-link>
        </td>
        <td>
            <router-link :to="{ name: 'livres', params: {genre: data.genre } }">
                {{this.data.genre}}
            </router-link>
        </td>
        <td v-if="!isHomePage">{{this.data.editeur}}</td>
        <td v-if="!isHomePage">{{this.data.nbPages}}</td>
        <td v-if="!isHomePage">{{this.data.lieuParution}}</td>
        <td v-if="isHomePage">
            <button type="button" class="btn btn-primary" @click="openDetailsLivre(data.id)"><i class="fas fa-address-book"></i></button>
            <button type="button" class="btn btn-info mx-1" @click="openUpdateLivre(data.id)"><i class="fas fa-pen-alt"></i></button>
            <button type="button" class="btn btn-danger" @click="deleteLivre(data.id)"><i class="far fa-trash-alt"></i></button>
        </td>
    </tr>
</template>
<script>
import { URI } from './../env'
export default {
  name: 'Livre',
  props: ['data', 'isHomePage'],

  methods: {
        openDetailsLivre(id) {
            this.$router.push({
                name: 'detailsLivre',
                params: {
                    id: id
                }
            })
        },
        openUpdateLivre(id) {
            this.$router.push({
                name: 'updateLivre',
                params: {
                    id: id
                }
            })
        },
        deleteLivre(id) {
            this.axios.delete(URI + 'livres/' + id).then(() => {
                this.$parent.deleteLivre(id);
            }).catch(() => {
                this.$bvToast.toast("La suppression du livre a échoué", {
                    title: 'Une erreur s\'est produite',
                    variant: 'danger',
                    solid: true,
                    autoHideDelay: 10000
                })
            });
        }
    }
}
</script>
