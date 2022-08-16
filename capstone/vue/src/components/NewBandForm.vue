<template>
  <form class="new-band-form" @submit.prevent="addNewBand">
    <div>
      <label for="name-input"> Band Name: </label>
      <input
        type="text"
        id="bandName" 
        class="name-input" 
        placeholder="Name"
        
        required 
        autofocus
       />
    </div>
    <div>
      <label for="bandMember-input"> Members: </label>
      <input  
      type="text" 
      id="bandMember"
      class="bandMember-input"
      placeholder="Name" 
      
      />
    </div>

    <div>
      <label for="managerId-input"> Manager Id: </label>
      <input class="managerId-input" type="number" placeholder="Your user ID" />
    </div>
    
    <div>
      <label for="image"> Cover Photo: </label>
      <input class="image" type="img" placeholder="Cover Image" />
    </div>

    <div class="field">
      <label class="label">Who Dat:</label>
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
  name: "add-band",
  data() {
    return {
      newBand: {
        bandName: "",
        bandImage: "",
        bandDesc: "",
        Members: "",
        mgrId: ""
      },
    };
  },
  methods: {
    addNewBand() {
      this.$store.commit("ADD_BAND", this.newBand);
      this.$router.push({ name: "home" });
    },
  },
};
</script>

<style></style>
