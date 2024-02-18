package com.diet.simplecaloriecounter.simplecaloriecounter;

import android.content.Context;

public class DBSetupInsert {

    private final Context context;

    public DBSetupInsert(Context ctx) {
        this.context = ctx;
    }


    public void setupInsertToCategories(String values){
        DBAdapter db = new DBAdapter(context);
        db.open();

        db.insert("categories" ,"category_id, category_name, category_parent_id, category_icon, category_note", values);
        db.close();
    }


    public void setupInsertToFood(String values){
        DBAdapter db = new DBAdapter(context);
        db.open();

        db.insert("food" ,"food_id, food_name, food_manufactor_name, food_serving_size, food_serving_measurement, food_serving_name_number, food_serving_name_word, food_energy, food_proteins, food_carbohydrates, food_fats, food_energy_calculated, food_proteins_calculated, food_carbohydrates_calculated, food_fats_calculated", values);
        db.close();
    }

    public void insertAllFood(){
        setupInsertToFood("NULL, 'Chickpeas', 'nil', '164', 'gram', '1', 'Cup', '164', '36', '105', '23', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Beans', 'nil', '254', 'gram', '1', 'Cup', '94', '19', '72', '3', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Lentils', 'nil', '198', 'gram', '1', 'Cup', '116', '36', '77', '3', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Peas', 'nil', '160', 'gram', '1', 'Cup', '84', '22', '60', '2', '92', '30', '62', '0'");

        setupInsertToFood("NULL, 'Dal Makhani', 'nil', '196', 'gram', '1', 'Cup', '168', '26', '56', '86', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Dal', 'nil', '214', 'gram', '1', 'Cup', '104', '26', '60', '18', '92', '30', '62', '0'");

        setupInsertToFood("NULL, 'Almonds', 'nil', '17', 'gram', '1', 'Hand full', '655', '83', '42', '530', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Ground Nut', 'nil', '17', 'gram', '1', 'Hand full', '567', '101', '104', '360', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Ground Nut Roasted', 'nil', '17', 'gram', '1', 'Hand full', '567', '101', '104', '360', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Walnut', 'nil', '17', 'gram', '1', 'Hand full', '687', '62', '44', '581', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Pistachio Nut', 'nil', '17', 'gram', '1', 'Hand full', '626', '79', '65', '482', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Cashew nut', 'nil', '17', 'gram', '1', 'Hand full', '596', '89', '89', '422', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Coconut Dry', 'nil', '1400', 'gram', '1', 'Quantity', '662', '27', '74', '561', '92', '30', '62', '0'");

        setupInsertToFood("NULL, 'Linseed seeds', 'nil', '10', 'gram', '1', 'Tablespoon', '530', '81', '116', '334', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Mustard seeds', 'nil', '10', 'gram', '1', 'Tablespoon', '541', '80', '95', '357', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Niger Seeds', 'nil', '10', 'gram', '1', 'Tablespoon', '515', '96', '69', '351', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Sunflower Seeds', 'nil', '10', 'gram', '1', 'Tablespoon', '620', '80', '70', '467', '92', '30', '62', '0'");

        setupInsertToFood("NULL, 'Broccoli', 'nil', '91', 'gram', '1', 'Cup', '38', '10', '25', '3', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Cabbage', 'nil', '89', 'gram', '1', 'Cup', '29', '5', '23', '1', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Carrot', 'nil', '128', 'gram', '1', 'Cup', '41', '3', '38', '1', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Garlic', 'nil', '136', 'gram', '1', 'Cup', '149', '25', '130', '2', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Onion', 'nil', '160', 'gram', '1', 'Cup', '40', '4', '37', '1', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Spinach', 'nil', '30', 'gram', '1', 'Cup', '23', '11', '14', '3', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Cucumber', 'nil', '133', 'gram', '1', 'Cup', '10', '3', '8', '0', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Radish', 'nil', '116', 'gram', '1', 'Cup', '16', '2', '13', '1', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Potato', 'nil', '38', 'gram', '1', 'Cup', '58', '10', '48', '1', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Tomato', 'nil', '180', 'gram', '1', 'Cup', '23', '4', '20', '2', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Mushroom', 'nil', '70', 'gram', '1', 'Cup', '22', '12', '13', '3', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Turnip', 'nil', '130', 'gram', '1', 'Cup', '28', '3', '25', '1', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Ginger', 'nil', '2', 'gram', '1', 'teaspoon(tsp)', '80', '5', '72', '7', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Lady’s Finger', 'nil', '100', 'gram', '1', 'Cup', '33', '7', '24', '2', '92', '30', '62', '0'");

        setupInsertToFood("NULL, 'Aloo muter', 'nil', '59', 'gram', '1', 'Cup', '127', '19', '42', '72', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Baingan Bharta', 'nil', '95', 'gram', '1', 'Cup', '105', '8', '55', '42', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Dum aloo', 'nil', '125', 'gram', '1', 'Cup', '171', '20', '136', '36', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Masala Lady finger(Bhindi)', 'nil', '186', 'gram', '1', 'Cup', '105', '5', '20', '80', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Palak Paneer', 'nil', '200', 'gram', '1', 'Cup', '183', '30', '16', '137', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Aloo gobi', 'nil', '155', 'gram', '1', 'Cup', '72', '7', '33', '32', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Gobi Manchurian', 'nil', '137', 'gram', '1', 'Cup', '172', '9', '60', '103', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Aloo sabzi', 'nil', '160', 'gram', '1', 'Cup', '88', '9', '64', '15', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Aloo Curry', 'nil', '238', 'gram', '1', 'Cup', '86', '5', '31', '50', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Cooked Bitter Gourd(karela)', 'nil', '128', 'gram', '1', 'Cup', '19', '2', '15', '2', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Aloo tikki', 'nil', '121', 'gram', '1', 'Serving', '190', '12', '55', '123', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Brinjal Masala', 'nil', '102', 'gram', '1', 'Serving', '140', '5', '25', '110', '92', '30', '62', '0'");

        setupInsertToFood("NULL, 'Orange', 'nil', '140', 'gram', '1', 'Quantity', '49', '4', '44', '1', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Apple', 'nil', '100', 'gram', '1', 'piece', '59', '56', '1.2', '1.8', '59', '56', '1.2', '1.8'");
        setupInsertToFood("NULL, 'Grapefruit', 'nil', '246', 'gram', '1', 'Quantity', '42', '3', '38', '1', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Lime', 'nil', '67', 'gram', '1', 'Quantity', '30', '3', '25', '2', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Lemon', 'nil', '84', 'gram', '1', 'Quantity', '29', '4', '22', '3', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Peaches', 'nil', '175', 'gram', '1', 'Quantity', '39', '4', '33', '2', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Mangoes', 'nil', '336', 'gram', '1', 'Quantity', '60', '4', '53', '3', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Apricots', 'nil', '35', 'gram', '1', 'Quantity', '50', '6', '40', '4', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Cherries', 'nil', '8', 'gram', '1', 'Quantity', '63', '4', '57', '2', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Plum', 'nil', '66', 'gram', '1', 'Quantity', '45', '4', '38', '3', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Coconut', 'nil', '85', 'gram', '1', 'Quantity', '456', '13', '191', '252', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Papaya', 'nil', '145', 'gram', '1', 'Quantity', '43', '2', '39', '2', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Guava', 'nil', '165', 'gram', '1', 'Quantity', '68', '10', '49', '9', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Pineapple', 'nil', '166', 'gram', '1', 'Quantity', '50', '2', '47', '1', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Banana', 'nil', '118', 'gram', '1', 'Quantity', '89', '4', '82', '3', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Berries', 'nil', '142', 'gram', '1', 'Cup', '46', '4', '38', '4', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Melons', 'nil', '177', 'gram', '1', 'Cup', '34', '3', '29', '2', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Tomatoes', 'nil', '123', 'gram', '1', 'Quantity', '18', '4', '12', '2', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Avocados', 'nil', '201', 'gram', '1', 'Quantity', '160', '8', '20', '132', '92', '30', '62', '0'");

        setupInsertToFood("NULL, 'Butter', 'nil', '14', 'gram', '1', 'tbsp', '729', '0', '0', '81', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Unsalted Butter', 'nil', '14', 'gram', '1', 'tbsp', '729', '0', '0', '81', '92', '30', '62', '0'");

        setupInsertToFood("NULL, 'Whipped Cream', 'nil', '3', 'gram', '1', 'tbsp', '250', '13', '37', '200', '92', '30', '62', '0'");

        setupInsertToFood("NULL, 'Traditional Yogurt', 'nil', '170', 'gram', '1', 'Container(6 oz)', '63', '20', '29', '14', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Almond Yogurt', 'nil', '172', 'gram', '1', 'Container(6 oz)', '88', '4', '68', '15', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Coconut Yogurt', 'nil', '170', 'gram', '1', 'Container(6 oz)', '95', '18', '75', '2', '92', '30', '62', '0'");

        setupInsertToFood("NULL, 'Gelato', 'nil', '113', 'gram', '1', 'Scoop', '197', '14', '71', '112', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Kulfi', 'nil', '73', 'gram', '1', 'Bar', '252', '26', '133', '93', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Cookies N‘ Cream', 'nil', '134', 'gram', '1', 'Cup', '250', '15', '125', '110', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Chocolate', 'nil', '132', 'gram', '1', 'Cup', '216', '15', '100', '101', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Mint Chocolate Chip', 'nil', '138', 'gram', '1', 'Cup', '219', '15', '100', '104', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Vanilla Cone', 'nil', '123', 'gram', '1', 'Single Cup', '223', '15', '114', '94', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Strawberry', 'nil', '132', 'gram', '1', 'Cup', '192', '13', '103', '76', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Mango', 'nil', '160', 'gram', '1', 'Cup', '290', '18', '140', '132', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Butter Scotch', 'nil', '239', 'gram', '1', 'Cup', '209', '12', '115', '82', '92', '30', '62', '0'");

        setupInsertToFood("NULL, 'Skim Milk', 'nil', '245', 'gram', '1', 'Cup', '34', '14', '19', '1', '92', '30', '62', '0'");
        setupInsertToFood("NULL, '1% Milk', 'nil', '244', 'gram', '1', 'Cup', '42', '14', '19', '9', '92', '30', '62', '0'");
        setupInsertToFood("NULL, '2% Milk', 'nil', '244', 'gram', '1', 'Cup', '50', '14', '18', '18', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Whole Milk', 'nil', '244', 'gram', '1', 'Cup', '61', '13', '19', '29', '92', '30', '62', '0'");

        setupInsertToFood("NULL, 'Mozzarella Cheese', 'nil', '28', 'gram', '1', 'Serving', '304', '90', '10', '204', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Cheddar Cheese', 'nil', '28', 'gram', '1', 'Serving', '411', '14', '93', '304', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Parmesan Cheese', 'nil', '5', 'gram', '1', 'tbsp', '420', '112', '48', '260', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Gouda Cheese', 'nil', '28', 'gram', '1', 'Serving', '361', '102', '9', '250', '92', '30', '62', '0'");

        setupInsertToFood("NULL, 'Chapati', 'nil', '40', 'gram', '1', 'Serving', '300', '32', '185', '83', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Phulkas', 'nil', '68', 'gram', '1', 'Serving', '297', '45', '184', '68', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Puris', 'nil', '44', 'gram', '1', 'Serving', '321', '21', '100', '200', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Kachori', 'nil', '20', 'gram', '1', 'Serving', '415', '30', '150', '235', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Poha', 'nil', '139', 'gram', '1', 'Serving', '114', '8', '104', '2', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Utappam', 'nil', '88', 'gram', '1', 'Serving', '182', '18', '113', '51', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Upma', 'nil', '155', 'gram', '1', 'Cup', '85', '9', '53', '23', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Idli', 'nil', '39', 'gram', '1', 'Piece', '149', '16', '123', '10', '92', '30', '62', '0'");

        setupInsertToFood("NULL, 'Aloo Parantha', 'nil', '131', 'gram', '1', 'Serving', '229', '18', '138', '73', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Gobi Parantha', 'nil', '125', 'gram', '1', 'Serving', '254', '20', '131', '103', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Plain Parantha', 'nil', '79', 'gram', '1', 'Serving', '327', '25', '183', '119', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Paneer Parantha', 'nil', '78', 'gram', '1', 'Serving', '226', '40', '96', '90', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Paneer Pyaaz Parantha', 'nil', '116', 'gram', '1', 'Serving', '239', '20', '136', '83', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Mooli Parantha', 'nil', '135', 'gram', '1', 'Serving', '221', '17', '140', '64', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Methi Parantha', 'nil', '80', 'gram', '1', 'Serving', '288', '30', '157', '101', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Lachha Parantha', 'nil', '100', 'gram', '1', 'Serving', '320', '28', '184', '108', '92', '30', '62', '0'");

        setupInsertToFood("NULL, 'Chicken Fried Rice', 'nil', '150', 'gram', '1', 'Cup', '133', '24', '87', '22', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Chinese Vegetable Fried Rice', 'nil', '167', 'gram', '1', 'Cup', '167', '20', '70', '77', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Fried Rice(plain)', 'nil', '137', 'gram', '1', 'Cup', '174', '16', '132', '26', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Curd Rice', 'nil', '225', 'gram', '1', 'Cup', '92', '8', '71', '13', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Khichdi', 'nil', '196', 'gram', '1', 'Cup', '121', '22', '33', '16', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Mutton Biryani', 'nil', '201', 'gram', '1', 'Cup', '160', '38', '40', '82', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Chicken Biryani', 'nil', '205', 'gram', '1', 'Cup', '142', '40', '60', '42', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Vegetable Biryani', 'nil', '169', 'gram', '1', 'Cup', '118', '10', '87', '21', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Rajma Pulao', 'nil', '250', 'gram', '1', 'Cup', '94', '15', '67', '12', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Vegetable Pulao', 'nil', '244', 'gram', '1', 'Cup', '115', '9', '90', '16', '92', '30', '62', '0'");

        setupInsertToFood("NULL, 'Honey', 'nil', '21', 'gram', '1', 'tbsp', '305', '1', '304', '0', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Granulated Sugar', 'nil', '13', 'gram', '1', 'tbsp', '377', '0', '377', '0', '92', '30', '62', '0'");


        setupInsertToFood("NULL, 'Green Pea/Split Pea Soup', 'nil', '259', 'gram', '1', 'Cup', '61', '13', '38', '10', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Lentil Soup', 'nil', '248', 'gram', '1', 'Cup', '56', '15', '31', '10', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Tomato Soup', 'nil', '244', 'gram', '1', 'Cup', '35', '3', '30', '2', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Minestrone Soup', 'nil', '240', 'gram', '1', 'Cup', '53', '8', '35', '10', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Sweet Corn Soup', 'nil', '250', 'gram', '1', 'Cup', '49', '5', '32', '12', '92', '30', '62', '0'");


        setupInsertToFood("NULL, 'Chicken Soup', 'nil', '255', 'gram', '1', 'Cup', '33', '8', '18', '7', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Mutton Soup', 'nil', '263', 'gram', '1', 'Cup', '100', '21', '18', '61', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Sweet Corn and Chicken Soup', 'nil', '259', 'gram', '1', 'Cup', '58', '10', '37', '11', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Chicken Manchow Soup', 'nil', '283', 'gram', '1', 'Cup', '162', '24', '75', '63', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Chicken Noodle Soup', 'nil', '248', 'gram', '1', 'Cup', '25', '5', '12', '9', '92', '30', '62', '0'");


        setupInsertToFood("NULL, 'Pork', 'nil', '247', 'gram', '1', 'Cooked Piece', '238', '105', '8', '125', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Beef', 'nil', '285', 'gram', '1', 'Cooked Piece', '291', '105', '8', '178', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Chicken Breast', 'nil', '172', 'gram', '1', 'Cooked Piece', '165', '124', '8', '33', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Mutton', 'nil', '242', 'gram', '1', 'Cooked Piece', '294', '98', '8', '188', '92', '30', '62', '0'");


        setupInsertToFood("NULL, 'Salmon', 'nil', '227', 'gram', '1', 'Fillet', '206', '88', '7', '111', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Tuna', 'nil', '85', 'gram', '1', 'Tuna Steak', '131', '118', '8', '5', '92', '30', '62', '0'");


        setupInsertToFood("NULL, 'Boiled Egg', 'nil', '44', 'gram', '1', 'Medium Egg', '155', '50', '9', '96', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'HALF Fried Egg', 'nil', '40', 'gram', '1', 'Medium Half Fried Egg', '195', '54', '8', '133', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Scrambled Egg', 'nil', '54', 'gram', '1', 'Medium Scrambled Egg', '148', '40', '10', '98', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Omelette', 'nil', '178', 'gram', '1', 'Medium Serving(3 egg omelette)', '181', '47', '6', '128', '92', '30', '62', '0'");

        setupInsertToFood("NULL, 'Butter Chicken', 'nil', '2400', 'gram', '1', 'Cup', '148', '38', '22', '88', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Egg Curry', 'nil', '236', 'gram', '1', 'Cup', '89', '17', '22', '50', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Fish Curry', 'nil', '236', 'gram', '1', 'Cup', '146', '68', '14', '64', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Fried Fish', 'nil', '87', 'gram', '1', 'Fillet', '229', '72', '37', '120', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Kadai Chicken', 'nil', '142', 'gram', '1', 'Cup', '120', '42', '21', '57', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Mutton Do Pyaza', 'nil', '134', 'gram', '1', 'Cup', '190', '38', '38', '114', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Mutton Korma', 'nil', '160', 'gram', '1', 'Cup', '176', '30', '16', '130', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Mutton Rogan Josh', 'nil', '236', 'gram', '1', 'Cup', '95', '29', '18', '48', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Seekh Kebab', 'nil', '155', 'gram', '1', 'Piece', '210', '72', '23', '115', '92', '30', '62', '0'");

        setupInsertToFood("NULL, 'Gelato', 'nil', '113', 'gram', '1', 'Scoop', '197', '14', '71', '112', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Kulfi', 'nil', '73', 'gram', '1', 'Bar', '252', '26', '133', '93', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Cookies N‘ Cream', 'nil', '134', 'gram', '1', 'Cup', '250', '15', '125', '110', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Chocolate', 'nil', '132', 'gram', '1', 'Cup', '216', '15', '100', '101', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Mint Chocolate Chip', 'nil', '138', 'gram', '1', 'Cup', '219', '15', '100', '104', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Vanilla Cone', 'nil', '123', 'gram', '1', 'Single Cup', '223', '15', '114', '94', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Strawberry', 'nil', '132', 'gram', '1', 'Cup', '192', '13', '103', '76', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Mango', 'nil', '160', 'gram', '1', 'Cup', '290', '18', '140', '132', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Butter Scotch', 'nil', '239', 'gram', '1', 'Cup', '209', '12', '115', '82', '92', '30', '62', '0'");

        setupInsertToFood("NULL, 'Cookie', 'nil', '30', 'gram', '1', 'Cookie', '493', '20', '251', '222', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Chocolate Bar', 'nil', '44', 'gram', '1', 'Bar', '534', '266', '237', '31', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Custard Mix', 'nil', '42', 'gram', '1', 'Cup', '410', '27', '326', '57', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Apple Pie', 'nil', '125', 'gram', '1', 'Pie', '237', '8', '130', '99', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Deep Fried Oreos', 'nil', '30', 'gram', '1', 'Cookie', '410', '20', '56', '234', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Rasgulla', 'nil', '131', 'gram', '1', 'Piece', '91', '5', '74', '12', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Kaju Katli', 'nil', '19', 'gram', '1', 'Piece', '484', '31', '238', '215', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Kaju Barfi', 'nil', '19', 'gram', '1', 'Piece', '484', '31', '238', '215', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Halwa', 'nil', '228', 'gram', '1', 'Cup', '121', '10', '58', '53', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Gulab Jamun', 'nil', '50', 'gram', '1', 'Piece', '298', '15', '151', '132', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Jalebi', 'nil', '55', 'gram', '1', 'Piece', '272', '9', '206', '57', '92', '30', '62', '0'");

        setupInsertToFood("NULL, 'Onion Pakodas', 'nil', '33', 'gram', '1', 'Piece', '242', '12', '100', '130', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Paneer Pakodas', 'nil', '30', 'gram', '1', 'Piece', '300', '67', '113', '120', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Aloo Pakodas', 'nil', '16', 'gram', '1', 'Piece', '125', '22', '90', '13', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Samosas', 'nil', '100', 'gram', '1', 'Piece', '262', '14', '93', '155', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Chicken Sandwich', 'nil', '187', 'gram', '1', 'Sandwich', '250', '64', '86', '100', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Cheese Sandwich', 'nil', '106', 'gram', '1', 'Sandwich', '345', '45', '116', '194', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Bread Roll', 'nil', '28', 'gram', '1', 'Roll', '273', '34', '182', '57', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Paneer Roll', 'nil', '150', 'gram', '1', 'Roll', '240', '24', '102', '114', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Spring Roll', 'nil', '64', 'gram', '1', 'Roll', '231', '22', '121', '88', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Aloo Patties', 'nil', '70', 'gram', '1', 'Piece', '150', '23', '76', '51', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Cheese Patties', 'nil', '40', 'gram', '1', 'Piece', '420', '36', '110', '274', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Soup Maggi', 'nil', '233', 'gram', '1', 'Cup', '68', '7', '38', '23', '92', '30', '62', '0'");

        setupInsertToFood("NULL, 'Beer', 'nil', '356', 'gram', '1', 'Bottle', '43', '2', '41', '0', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Gin', 'nil', '42', 'gram', '1', 'Shot', '231', '0', '0', '0', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Whiskey', 'nil', '42', 'gram', '1', 'Shot', '231', '0', '0', '0', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Rum', 'nil', '42', 'gram', '1', 'Shot', '231', '0', '0', '0', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Wine', 'nil', '147', 'gram', '1', 'Glass', '83', '0', '24', '0', '92', '30', '62', '0'");

        setupInsertToFood("NULL, 'Chocolate Cake', 'nil', '109', 'gram', '1', 'Piece', '389', '14', '193', '182', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Choco Lava Cake', 'nil', '154', 'gram', '1', 'Cake', '429', '26', '164', '239', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Strawberry Cheesecake', 'nil', '221', 'gram', '1', 'Piece', '218', '10', '104', '104', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Vanilla Cheesecake', 'nil', '125', 'gram', '1', 'Piece', '321', '22', '97', '202', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Cinnamon Rolls', 'nil', '88', 'gram', '1', 'Large Piece', '330', '17', '212', '101', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Cheese Pastry', 'nil', '71', 'gram', '1', 'Pastry', '375', '32', '146', '197', '92', '30', '62', '0'");

        setupInsertToFood("NULL, 'Cheese Pizza', 'nil', '65', 'gram', '1', 'Small Slice', '266', '46', '132', '88', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Veggie Pizza', 'nil', '78', 'gram', '1', 'Small Slice', '244', '40', '122', '82', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Pepperoni Pizza', 'nil', '80', 'gram', '1', 'Small Slice', '283', '47', '128', '108', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Meat Pizza', 'nil', '77', 'gram', '1', 'Small Slice', '299', '52', '105', '142', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Margherita Pizza', 'nil', '107', 'gram', '1', 'Medium Slice', '159', '17', '66', '76', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'BBQ Chicken Pizza', 'nil', '598', 'gram', '1', 'Small Pizza', '247', '55', '106', '86', '92', '30', '62', '0'");

        setupInsertToFood("NULL, 'Cheese Burger', 'nil', '227', 'gram', '1', 'Burger', '274', '86', '60', '128', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Bacon Burger', 'nil', '211', 'gram', '1', 'Burger', '282', '62', '77', '143', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Veggie Burger', 'nil', '193', 'gram', '1', 'Burger', '189', '37', '74', '78', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Chicken Burger', 'nil', '207', 'gram', '1', 'Burger', '259', '56', '115', '88', '92', '30', '62', '0'");

        setupInsertToFood("NULL, 'Country Fried Chicken', 'nil', '121', 'gram', '1', 'Piece', '250', '83', '30', '137', '92', '30', '62', '0'");

        setupInsertToFood("NULL, 'French Fries', 'nil', '117', 'gram', '1', 'Medium Serving', '312', '14', '165', '133', '92', '30', '62', '0'");

        setupInsertToFood("NULL, 'Cheese Hot Dog', 'nil', '126', 'gram', '1', 'Serving', '253', '35', '76', '142', '92', '30', '62', '0'");
        setupInsertToFood("NULL, 'Vegetarian Hot Dog', 'nil', '40', 'gram', '1', 'Serving', '125', '70', '33', '12', '92', '30', '62', '0'");

    }


}
