<template>
    <div id="add-brewery">
        <div class="add-brewery-form">
            <fieldset>
                <legend> Update Your Brewery </legend>
              <p>Only enter the information about your brewery to update.</p>
                <label for="brewery-name">New Brewery Name:</label><br>
                    <input type="text" id="brewery" name="brewery" value="My Brewery"><br>
                <label for="brewery-description">New Description:</label><br>
                    <input type="text" id="brewery-description" name="brewery-description" value="Description"><br>
                <label for="brewery-street-name">New Street Address:</label><br>
                    <input type="text" id="brewery-street-name" name="brewery-street-name" value="Street Address"><br>
                <label for="brewery-zip-code">New Zip Code:</label><br>
                    <input type="text" id="brewery-zip-code" name="brewery-zip-code" value="Zip Code"><br>
                <label for="brewery-phone-number">New Phone Number:</label><br>
                    <input type="text" id="brewery-phone-number" name="brewery-phone-number" value="Phone Number"><br>
                <label for="brewery-url">New Brewery URL:</label><br>
                    <input type="text" id="brewery-url" name="brewery-url" value="URL"><br>
                <input type="submit" value="Submit">
            </fieldset>
        </div>
    </div>
    
</template>

<style scoped>
    div {
        font-family: Moon;
    }

</style>