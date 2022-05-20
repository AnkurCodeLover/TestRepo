Feature: Test the Nomenclature of Economic Activities corresponding to order ID

  @SanityTest @ApiTest
  Scenario: Test Nomenclature of Economic Activities value using data table
    Given set the location of excel file to property file named "path" and"src\test\java\resources\NACE_REV2_20220512_203658.xlsx"
    When Read the data for sheet name "NACE_REV2_20220512_203658"
    Then I validate the below value corresponding to the order id "398481"
      | Order  | Level | Code | Parent | Description                       | This item includes                                                                                                                                                                                                                                                       | This item also includes | Rulings | This item excludes | Reference to ISIC Rev. 4 |
      | 398481 |     1 | A    |        | AGRICULTURE, FORESTRY AND FISHING | This section includes the exploitation of vegetal and animal natural resources, comprising the activities of growing of crops, raising and breeding of animals, harvesting of timber and other plants, animals or animal products from a farm or their natural habitats. |                         |         |                    | A                        |



  @Sanity @ApiTest
  Scenario: Test Nomenclature of Economic Activities with incorrect order id
      Given set the location of excel file to property file named "path" and"src\test\java\resources\NACE_REV2_20220512_203658.xlsx"
    When Read the data for sheet name "NACE_REV2_20220512_203658"
    Then I validate the below value corresponding to the order id "123456"
      | Order  | Level | Code | Parent | Description                       | This item includes                                                                                                                                                                                                                                                       | This item also includes | Rulings | This item excludes | Reference to ISIC Rev. 4 |
      | 398481 |     1 | A    |        | AGRICULTURE, FORESTRY AND FISHING | This section includes the exploitation of vegetal and animal natural resources, comprising the activities of growing of crops, raising and breeding of animals, harvesting of timber and other plants, animals or animal products from a farm or their natural habitats. |                         |         |                    | A                        |

