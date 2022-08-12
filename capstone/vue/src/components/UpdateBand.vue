<template>
  <form class="new-band-form" v-on:submit.prevent>
    <div>
      <label for="name-input"> Band Name: </label>
      <input
        class="name-input"
        type="text"
        placeholder="Name"
        v-model="band.bandName"
      />
    </div>
    <div>
      <label for="bandMember-input"> Member: </label>
      <input class="bandMember-input" type="text" placeholder="Name" />
    </div>
    <div>
      <label for="bandMember-input"> Member: </label>
      <input class="bandMember-input" type="text" placeholder="Name" />
    </div>
    <div class="field">
      <label for="genre-one"> First Genre: </label>
      <div class="select is-small">
        <div class="select">
          <select>
            <option>Jazz</option>
            <option>Bluegrass</option>
            <option>Rock</option>
            <option>Country</option>
            <option>Americana</option>
            <option>Cajun</option>
            <option>Blues</option>
            <option>Gospel</option>
            <option>R-B</option>
            <option>Zydeco</option>
            <option>Funk</option>
            <option>Soul</option>
          </select>
        </div>
      </div>
    </div>

    <div class="field">
      <label for="genre-two"> Second Genre: </label>
      <div class="select is-small">
        <div class="select">
          <select>
            <option>Jazz</option>
            <option>Bluegrass</option>
            <option>Rock</option>
            <option>Country</option>
            <option>Americana</option>
            <option>Cajun</option>
            <option>Blues</option>
            <option>Gospel</option>
            <option>R&B</option>
            <option>Zydeco</option>
            <option>Funk</option>
            <option>Soul</option>
          </select>
        </div>
      </div>
    </div>
    <div>
      <label for="image"> Cover Photo: </label>
      <input class="image" type="img" placeholder="Cover Image" />
    </div>

    <div class="field">
      <label class="label">Who Dat</label>
      <div class="control">
        <textarea class="textarea" placeholder="Description"></textarea>
      </div>
    </div>

    <div class="control">
      <button type="submit" class="button is-primary">SAVE</button>
    </div>
  </form>
</template>

<script>
export default {
  name: "update-band",
  props: ["bandId"],
  data() {
    return {
      title: "",
    };
  },
  methods: {
    updateBands() {},
  },
  created() {},
};
</script>

<style></style>
