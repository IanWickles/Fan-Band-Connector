<template>
  <div class="show-container">
    <input
      class="input is-rounded"
      v-model="input"
      name="byShow"
      type="text"
      placeholder="Search by show"
    />
    <div class="show">
      <tbody>
        <tr
          v-for="show in this.$store.state.shows"
          v-bind:key="show.showId"
        >
          <div class="container">
            <td>
              <router-link
                v-bind:to="{ name: 'show', params: { showId: show.showId } }"
                >{{ show.showTitle }}</router-link
              >
            </td>
            <h2 class="time">Show Time: {{ show.showTime }}</h2>
            <br>
            <h2 class="description">{{ show.showDesc }}</h2>
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
</style>