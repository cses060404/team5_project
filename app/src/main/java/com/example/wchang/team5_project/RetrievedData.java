package com.example.wchang.team5_project;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * public class RetrievedData
 *      This is the template to retrieve the data from web api database
 */
public class RetrievedData {

        @SerializedName("old_api_id")
        @Expose
        private Object oldApiId;
        @SerializedName("item_id")
        @Expose
        private String itemId;
        @SerializedName("item_name")
        @Expose
        private String itemName;
        @SerializedName("leg_loc_id")
        @Expose
        private Object legLocId;
        @SerializedName("brand_id")
        @Expose
        private String brandId;
        @SerializedName("brand_name")
        @Expose
        private String brandName;
        @SerializedName("item_description")
        @Expose
        private String itemDescription;
        @SerializedName("updated_at")
        @Expose
        private String updatedAt;
        @SerializedName("nf_ingredient_statement")
        @Expose
        private String nfIngredientStatement;
        @SerializedName("nf_water_grams")
        @Expose
        private Object nfWaterGrams;
        @SerializedName("nf_calories")
        @Expose
        private Integer nfCalories;
        @SerializedName("nf_calories_from_fat")
        @Expose
        private Integer nfCaloriesFromFat;
        @SerializedName("nf_total_fat")
        @Expose
        private Object nfTotalFat;
        @SerializedName("nf_saturated_fat")
        @Expose
        private Object nfSaturatedFat;
        @SerializedName("nf_trans_fatty_acid")
        @Expose
        private Object nfTransFattyAcid;
        @SerializedName("nf_polyunsaturated_fat")
        @Expose
        private Object nfPolyunsaturatedFat;
        @SerializedName("nf_monounsaturated_fat")
        @Expose
        private Object nfMonounsaturatedFat;
        @SerializedName("nf_cholesterol")
        @Expose
        private Object nfCholesterol;
        @SerializedName("nf_sodium")
        @Expose
        private Object nfSodium;
        @SerializedName("nf_total_carbohydrate")
        @Expose
        private Object nfTotalCarbohydrate;
        @SerializedName("nf_dietary_fiber")
        @Expose
        private Object nfDietaryFiber;
        @SerializedName("nf_sugars")
        @Expose
        private Integer nfSugars;
        @SerializedName("nf_protein")
        @Expose
        private Integer nfProtein;
        @SerializedName("nf_vitamin_a_dv")
        @Expose
        private Integer nfVitaminADv;
        @SerializedName("nf_vitamin_c_dv")
        @Expose
        private Integer nfVitaminCDv;
        @SerializedName("nf_calcium_dv")
        @Expose
        private Integer nfCalciumDv;
        @SerializedName("nf_iron_dv")
        @Expose
        private Integer nfIronDv;
        @SerializedName("nf_refuse_pct")
        @Expose
        private Object nfRefusePct;
        @SerializedName("nf_servings_per_container")
        @Expose
        private Integer nfServingsPerContainer;
        @SerializedName("nf_serving_size_qty")
        @Expose
        private Double nfServingSizeQty;
        @SerializedName("nf_serving_size_unit")
        @Expose
        private String nfServingSizeUnit;
        @SerializedName("nf_serving_weight_grams")
        @Expose
        private Integer nfServingWeightGrams;
        @SerializedName("allergen_contains_milk")
        @Expose
        private Object allergenContainsMilk;
        @SerializedName("allergen_contains_eggs")
        @Expose
        private Object allergenContainsEggs;
        @SerializedName("allergen_contains_fish")
        @Expose
        private Object allergenContainsFish;
        @SerializedName("allergen_contains_shellfish")
        @Expose
        private Object allergenContainsShellfish;
        @SerializedName("allergen_contains_tree_nuts")
        @Expose
        private Object allergenContainsTreeNuts;
        @SerializedName("allergen_contains_peanuts")
        @Expose
        private Object allergenContainsPeanuts;
        @SerializedName("allergen_contains_wheat")
        @Expose
        private Object allergenContainsWheat;
        @SerializedName("allergen_contains_soybeans")
        @Expose
        private Object allergenContainsSoybeans;
        @SerializedName("allergen_contains_gluten")
        @Expose
        private Object allergenContainsGluten;
        @SerializedName("usda_fields")
        @Expose
        private Object usdaFields;

        public Object getOldApiId() {
            return oldApiId;
        }

        public void setOldApiId(Object oldApiId) {
            this.oldApiId = oldApiId;
        }

        public String getItemId() {
            return itemId;
        }

        public void setItemId(String itemId) {
            this.itemId = itemId;
        }

        public String getItemName() {
            return itemName;
        }

        public void setItemName(String itemName) {
            this.itemName = itemName;
        }

        public Object getLegLocId() {
            return legLocId;
        }

        public void setLegLocId(Object legLocId) {
            this.legLocId = legLocId;
        }

        public String getBrandId() {
            return brandId;
        }

        public void setBrandId(String brandId) {
            this.brandId = brandId;
        }

        public String getBrandName() {
            return brandName;
        }

        public void setBrandName(String brandName) {
            this.brandName = brandName;
        }

        public String getItemDescription() {
            return itemDescription;
        }

        public void setItemDescription(String itemDescription) {
            this.itemDescription = itemDescription;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        public String getNfIngredientStatement() {
            return nfIngredientStatement;
        }

        public void setNfIngredientStatement(String nfIngredientStatement) {
            this.nfIngredientStatement = nfIngredientStatement;
        }

        public Object getNfWaterGrams() {
            return nfWaterGrams;
        }

        public void setNfWaterGrams(Object nfWaterGrams) {
            this.nfWaterGrams = nfWaterGrams;
        }

        public Integer getNfCalories() {
            return nfCalories;
        }

        public void setNfCalories(Integer nfCalories) {
            this.nfCalories = nfCalories;
        }

        public Integer getNfCaloriesFromFat() {
            return nfCaloriesFromFat;
        }

        public void setNfCaloriesFromFat(Integer nfCaloriesFromFat) {
            this.nfCaloriesFromFat = nfCaloriesFromFat;
        }

        public Object getNfTotalFat() {
            return nfTotalFat;
        }

        public void setNfTotalFat(Object nfTotalFat) {
            this.nfTotalFat = nfTotalFat;
        }

        public Object getNfSaturatedFat() {
            return nfSaturatedFat;
        }

        public void setNfSaturatedFat(Object nfSaturatedFat) {
            this.nfSaturatedFat = nfSaturatedFat;
        }

        public Object getNfTransFattyAcid() {
            return nfTransFattyAcid;
        }

        public void setNfTransFattyAcid(Object nfTransFattyAcid) {
            this.nfTransFattyAcid = nfTransFattyAcid;
        }

        public Object getNfPolyunsaturatedFat() {
            return nfPolyunsaturatedFat;
        }

        public void setNfPolyunsaturatedFat(Object nfPolyunsaturatedFat) {
            this.nfPolyunsaturatedFat = nfPolyunsaturatedFat;
        }

        public Object getNfMonounsaturatedFat() {
            return nfMonounsaturatedFat;
        }

        public void setNfMonounsaturatedFat(Object nfMonounsaturatedFat) {
            this.nfMonounsaturatedFat = nfMonounsaturatedFat;
        }

        public Object getNfCholesterol() {
            return nfCholesterol;
        }

        public void setNfCholesterol(Object nfCholesterol) {
            this.nfCholesterol = nfCholesterol;
        }

        public Object getNfSodium() {
            return nfSodium;
        }

        public void setNfSodium(Object nfSodium) {
            this.nfSodium = nfSodium;
        }

        public Object getNfTotalCarbohydrate() {
            return nfTotalCarbohydrate;
        }

        public void setNfTotalCarbohydrate(Object nfTotalCarbohydrate) {
            this.nfTotalCarbohydrate = nfTotalCarbohydrate;
        }

        public Object getNfDietaryFiber() {
            return nfDietaryFiber;
        }

        public void setNfDietaryFiber(Object nfDietaryFiber) {
            this.nfDietaryFiber = nfDietaryFiber;
        }

        public Integer getNfSugars() {
            return nfSugars;
        }

        public void setNfSugars(Integer nfSugars) {
            this.nfSugars = nfSugars;
        }

        public Integer getNfProtein() {
            return nfProtein;
        }

        public void setNfProtein(Integer nfProtein) {
            this.nfProtein = nfProtein;
        }

        public Integer getNfVitaminADv() {
            return nfVitaminADv;
        }

        public void setNfVitaminADv(Integer nfVitaminADv) {
            this.nfVitaminADv = nfVitaminADv;
        }

        public Integer getNfVitaminCDv() {
            return nfVitaminCDv;
        }

        public void setNfVitaminCDv(Integer nfVitaminCDv) {
            this.nfVitaminCDv = nfVitaminCDv;
        }

        public Integer getNfCalciumDv() {
            return nfCalciumDv;
        }

        public void setNfCalciumDv(Integer nfCalciumDv) {
            this.nfCalciumDv = nfCalciumDv;
        }

        public Integer getNfIronDv() {
            return nfIronDv;
        }

        public void setNfIronDv(Integer nfIronDv) {
            this.nfIronDv = nfIronDv;
        }

        public Object getNfRefusePct() {
            return nfRefusePct;
        }

        public void setNfRefusePct(Object nfRefusePct) {
            this.nfRefusePct = nfRefusePct;
        }

        public Integer getNfServingsPerContainer() {
            return nfServingsPerContainer;
        }

        public void setNfServingsPerContainer(Integer nfServingsPerContainer) {
            this.nfServingsPerContainer = nfServingsPerContainer;
        }

        public Double getNfServingSizeQty() {
            return nfServingSizeQty;
        }

        public void setNfServingSizeQty(Double nfServingSizeQty) {
            this.nfServingSizeQty = nfServingSizeQty;
        }

        public String getNfServingSizeUnit() {
            return nfServingSizeUnit;
        }

        public void setNfServingSizeUnit(String nfServingSizeUnit) {
            this.nfServingSizeUnit = nfServingSizeUnit;
        }

        public Integer getNfServingWeightGrams() {
            return nfServingWeightGrams;
        }

        public void setNfServingWeightGrams(Integer nfServingWeightGrams) {
            this.nfServingWeightGrams = nfServingWeightGrams;
        }

        public Object getAllergenContainsMilk() {
            return allergenContainsMilk;
        }

        public void setAllergenContainsMilk(Object allergenContainsMilk) {
            this.allergenContainsMilk = allergenContainsMilk;
        }

        public Object getAllergenContainsEggs() {
            return allergenContainsEggs;
        }

        public void setAllergenContainsEggs(Object allergenContainsEggs) {
            this.allergenContainsEggs = allergenContainsEggs;
        }

        public Object getAllergenContainsFish() {
            return allergenContainsFish;
        }

        public void setAllergenContainsFish(Object allergenContainsFish) {
            this.allergenContainsFish = allergenContainsFish;
        }

        public Object getAllergenContainsShellfish() {
            return allergenContainsShellfish;
        }

        public void setAllergenContainsShellfish(Object allergenContainsShellfish) {
            this.allergenContainsShellfish = allergenContainsShellfish;
        }

        public Object getAllergenContainsTreeNuts() {
            return allergenContainsTreeNuts;
        }

        public void setAllergenContainsTreeNuts(Object allergenContainsTreeNuts) {
            this.allergenContainsTreeNuts = allergenContainsTreeNuts;
        }

        public Object getAllergenContainsPeanuts() {
            return allergenContainsPeanuts;
        }

        public void setAllergenContainsPeanuts(Object allergenContainsPeanuts) {
            this.allergenContainsPeanuts = allergenContainsPeanuts;
        }

        public Object getAllergenContainsWheat() {
            return allergenContainsWheat;
        }

        public void setAllergenContainsWheat(Object allergenContainsWheat) {
            this.allergenContainsWheat = allergenContainsWheat;
        }

        public Object getAllergenContainsSoybeans() {
            return allergenContainsSoybeans;
        }

        public void setAllergenContainsSoybeans(Object allergenContainsSoybeans) {
            this.allergenContainsSoybeans = allergenContainsSoybeans;
        }

        public Object getAllergenContainsGluten() {
            return allergenContainsGluten;
        }

        public void setAllergenContainsGluten(Object allergenContainsGluten) {
            this.allergenContainsGluten = allergenContainsGluten;
        }

        public Object getUsdaFields() {
            return usdaFields;
        }

        public void setUsdaFields(Object usdaFields) {
            this.usdaFields = usdaFields;
        }

}

