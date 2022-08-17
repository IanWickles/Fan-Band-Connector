<template>
  <div class="show-container">
    <div class="show">
      <tbody>
        <tr
          v-for="show in this.$store.state.shows"
          v-bind:key="show.showId"
        >
          <div class="card column is-offset-one-quarter">
            <td>
              <router-link class="card-header"
                v-bind:to="{ name: 'show', params: { showId: show.showId } }"
                >{{ show.showTitle }}</router-link
              >
            </td>
            <h2 class="card-header">Show Time: {{ show.showTime }}</h2>
            <br>
            <h2 class="card-content">{{ show.showDesc }}</h2>
          </div>
        </tr>
      </tbody>
    </div>
  </div>
</template>

<script>
import showService from "@/services/ShowService.js";

export default {
  name: "show-list",
  methods: {
    getShows() {
      showService.list().then((response) => {
        this.$store.commit("SET_SHOWS", response.data);
      });
    },
    deleteShow() {},
  },
  created() {
    this.getShows();
  },
};
</script>

<style>
.container {
  padding: 10px;
}
.card-header{
  font-size: 30px;
}
.card-content{
  font-size: 30px;
}

</style>