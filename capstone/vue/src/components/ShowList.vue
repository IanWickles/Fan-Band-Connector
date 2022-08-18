<template>
  <div class="show">
    <table>
      <tbody>
        <tr>
          <td>
            <input
              class="input is-rounded"
              v-model="filter.showTitle"
              name="byShow"
              type="text"
              placeholder="Search by show"
            />
          </td>
        </tr>

        <tr v-for="show in filteredList" :key="show.showId">
          <td class="card">
            <router-link
              class="card-header"
              v-bind:to="{ name: 'show', params: { showId: show.showId } }"
              >{{ show.showTitle }}</router-link
            >
            <h2 class="card-header">Show Time: {{ show.showTime }}</h2>
            <h2 class="card-content">{{ show.showDesc }}</h2>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import showService from "@/services/ShowService.js";

export default {
  name: "show-list",
  data() {
    return {
      filter: {
        showId: 0,
        showTime: 0,
        showTitle: "",
        showDesc: "",
        venueId: 0,
      },
    };
  },
  computed: {
    filteredList() {
      let showList = this.$store.state.shows;
      if (this.filter.showTitle != "") {
        showList = showList.filter((show) =>
          show.showTitle
            .toLowerCase()
            .includes(this.filter.showTitle.toLowerCase())
        );
      }
      return showList;
    },
  },
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
.show {
  display: grid;
  grid-template-columns: repeat(2, 1fr);
}
.card-header {
  font-size: 30px;
}
.card-content {
  font-size: 30px;
}
</style>
