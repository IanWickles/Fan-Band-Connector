<template>
  <div class="genres-container">
    <ul>
      <li v-for="genre in this.$store.state.genres" :key="genre.genreId">
        {{ genre.genreName }}
      </li>
    </ul>
  </div>
</template>

<script>
import genreService from "@/services/GenresService.js";

export default {
  name: "genre-list",
  methods: {
    getGenres() {
      genreService.list().then((response) => {
        this.$store.commit("SET_GENRES", response.data);
      });
    },
    addGenre() {
    
    },
    updateGenre() {

    },
    deleteGenre() {
        
    }
  },
  created() {
    this.getGenres();
  },
};
</script>

<style>
</style>