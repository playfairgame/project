package com.qa.meschino.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.meschino.basepages.BasePage;
import com.qa.meschino.constants.MWConstants;

public class MyHRAPage extends BasePage{
	
	public MyHRAPage(WebDriver driver, ExtentTest logger){
	
		
		super(driver,logger);
	}
	
	public  final String Q1="1.Please select your weight in pounds from the drop-down menu.";
	public  final String Q2="2.Please select your waist circumference in inches from the drop-down menu.";
	public  final String Q3="3.On average, how often do you eat any of the following foods? ·   Ground beef, Steak, Hamburger, any other type of Beef ·   High fat Luncheon meats (e.g., salami, bologna, hot dogs) ·   Bacon, Spare ribs, Sausage or any other pork products ·   Chicken wings";
	public  final String Q4="4.How often do you consume any of the following foods? ·   Cheeses with greater than 20% Milk Fat (MF), e.g., cheddar, mozzarella, Monterey Jack, brick, cream cheese, parmesan ·   Homogenized milk ·   Yogurt that is more than 1% MF ·   Regular Ice cream";
	public  final String Q5="5.How often do you use cream in your coffee or tea?";
	public  final String Q6="6.How often do you use butter on bread products such as toast, bagels?";
	public  final String Q7="7.How often do you use butter for cooking or on baked potatoes or vegetables?";
	public  final String Q8="8.Do you use regular sour cream or high saturated fat salad dressings (e.g., French, Thousand Islands, etc.) more than once per week?";
	public  final String Q9="9.What is your weekly whole egg consumption on average?";
	public  final String Q10="10.How often do you eat fried foods? (deep-fried or pan-fried)";
	public  final String Q11="11.Do you choose poultry or fish in place of red meat, pork or fried foods in most situations?";
	public  final String Q12="12.Are you a vegetarian or near vegetarian?";
	public  final String Q13="13.How often do you consume any of the following? ·   2% milk ·   Margarine ·   Yogurt that is 2% MF ·   Low-fat sour cream";
	public  final String Q14="14.How often do you consume any of the following foods? ·     Pastries such as cakes, donuts, croissants, turnovers, cookies (3 or more) ·     Non low-fat muffins ·     Rich desserts ·     Premium ice cream";
	public  final String Q15="15.How often do you consume any high-fat snack foods? (e.g., potato chips, nachos, any type of fried chips, cheesies, regular chocolate bars, other chocolate treats, etc.)";
	public  final String Q16="16.How often do you consume sugary carbohydrate snacks & drinks? ·   Regular soft drinks ·   Licorice, jujubes, hard candies, gummy bears ·   Sweet, refined breakfast cereals, rice crispy squares";
	public  final String Q17="17.On average, how many servings of garden vegetables do you consume on a daily basis? (e.g., carrots, tomatoes, broccoli, cauliflower, peppers, romaine lettuce, spinach, collard greens, kale, etc.)";
	public  final String Q18="18.On average, how many servings per day do you consume of any starchy carbohydrate foods, such as pasta, rice, beans, peas, corn, oatmeal, etc.?";
	public  final String Q19="19.On average, how many servings of fruit do you have per day? Note: 1 serving = 1 whole fruit (e.g., apple, orange, peach), ½ cup chopped fruit (e.g., fruit salad), 8 oz. fruit juice";
	public  final String Q20="20.How many alcoholic drinks do you have in typical day? Note: One drink equals: ·      341 mL/12 oz (1 bottle) of beer or regular strength beer (5% alcohol) ·      142 mL/5 oz wine (12% alcohol) ·      43 mL/1-½ oz spirits (40% alcohol) ·      3 oz sherry or port";
	public  final String Q21="21.Is there any day of the week, for instance on the weekend, where you have 4 or more drinks in one day?";
	public  final String Q22="22.Regarding the question above, how many times per month, on average, would you consume 4 or more drinks in one day?";
	public  final String Q23="23.How often, on average, do you consume any food or drinks containing high amounts of artificial sweeteners and/or food additives, colours, artifical flavours? Examples of these food/drink items: diet and regular soft drinks, potato chips, nachos, cheesies, corn chips, licorice, jujubes, gummy bears, gelatins, ice cream, fruit ices, sherbet, rice crispy squares, granola bars, or other similar types of snacks.";
	public  final String Q24="24.Do you take a multiple vitamin and mineral supplement daily?";
	public  final String Q25="25.Your doctor has informed you that you have heart trouble or a heart condition of some kind?";
	public  final String Q26="26.You frequently have pain in your chest or have had chest pain recently?";
	public  final String Q27="27.You often feel faint or have spells of severe dizziness that are not caused by an inner ear condition?";
	public  final String Q28="28.You have been informed that you have high blood pressure?";
	public  final String Q29="29.How many minutes a week do you perform endurance/aerobic activity that makes your heart beat faster than normal, causes you to sweat a little or breathe faster?";
	public  final String Q30="30.Resistance Exercise, such as weight lifting/resistance training?";
	public  final String Q31="31.Flexibility and stretching exercise such as yoga, Pilates, formal stretching program?";
	public  final String Q32="32.Do you eat fewer than 5 fruit and vegetable servings per day, on average?";
	public  final String Q33="33.Do you often experience a scaly, flaky, seborrheic condition at the outer nose margins above the lips?";
	public  final String Q34="34.Do you have soft nails or do they chip, crack or peel easily, and/or are brittle or contain ridges (not smooth)?";
	public  final String Q35="35.Are there white spots on your fingernails?";
	public  final String Q36="36.Have you noticed many small red spots on your skin?";
	public  final String Q37="37.Do you drink more than two cups of coffee or caffeinated tea (of any kind) per day, on average?";
	public  final String Q38="38.What is your current smoking status?";
	public  final String Q39="39.How long have you smoked, in years?";
	public  final String Q40="40.How many cigarettes do you smoke per day, on average?";
	public  final String Q41="41.Which of the following describes your feelings about smoking?";
	public  final String Q42="42.As an ex-smoker, how many years did you smoke?";
	public  final String Q43="43.As an ex-smoker, how long ago did you smoke?";
	public  final String Q44="44.As an ex-smoker, how many cigarettes did you smoke per day, on average?";
	public  final String Q45="45.Has your skin been damaged by sunlight and/or do you use a tanning bed more than once per month?";
	public  final String Q46="46.Do you often experience cracks at the corners of your lips?";
	public  final String Q47="47.Do you often experience a sore or burning tongue?";
	public  final String Q48="48.Have you experienced a reduced ability to taste food?";
	public  final String Q49="49.Do your gums bleed easily?";
	public  final String Q50="50.Do you bruise easily?";
	public  final String Q51="51.Are you a slow healer from bruises and cuts?";
	public  final String Q52="52.Do you feel chronically tired?";
	public  final String Q53="53.Do you have irregular or erratic eating patterns?";
	public  final String Q54="54.Are you on a weight loss or calorie restricted diet?";
	public  final String Q55="55.Do you feel run down and/or are you experiencing a weakened state of immunity? (e.g., frequent colds, sore throat, or known to have an immune-compromised state)";
	public  final String Q56="56.Does your hair fall out easily, and/or is it dry and brittle and/or does it lack optimal luster and sheen?";
	public  final String Q57="57.Laxatives?";
	public  final String Q58="58.Antacids?";
	public  final String Q59="59.Pain-killers / Anti-inflammatories? (ASA- Acetylsalicylic acid, etc.)";
	public  final String Q60="60.Do you regularly take any prescription medications?";
	public  final String Q61="61.Barbiturates?";
	public  final String Q62="62.Antidepressants?";
	public  final String Q63="63.Amphetamines?";
	public  final String Q64="64.Anti-convulsant phenytoin drugs?";
	public  final String Q65="65.Antibiotics?";
	public  final String Q66="66.Cholesterol-lowering Bile Acid Sequestrant drugs?";
	public  final String Q67="67.Cholesterol-lowering Statin Drugs?";
	public  final String Q68="68.ACE-inhibitors? (usually prescribed for high blood pressure or diabetics)";
	public  final String Q69="69.Beta-blockers? (often prescribed for high blood pressure and arrhythmia)";
	public  final String Q70="70.Digitalis?";
	public  final String Q71="71.Corticosteroids?";
	public  final String Q72="72.Indomethacin?";
	public  final String Q73="73.Diuretics?";
	public  final String Q74="74.Specific drug for Gout?";
	public  final String Q75="75.L-dopa for Parkinson’s disease?";
	public  final String Q76="76.Theophylline?";
	public  final String Q77="77.Have you been diagnosed with high cholesterol?";
	public  final String Q78="78.What is your Total Cholesterol level?";
	public  final String Q79="79.What is your LDL-Cholesterol level?";
	public  final String Q80="80.What is your HDL-Cholesterol level?";
	public  final String Q81="81.Do you have a history of heart disease?";
	public  final String Q82="82.Have you had a previous heart attack?";
	public  final String Q83="83.Have you had a previous stroke?";
	public  final String Q84="84.Do you have high triglyceride levels?";
	public  final String Q85="85.Do you have high blood pressure?";
	public  final String Q86="86.What is your current Blood Pressure reading?";
	public  final String Q87="87.Have you been diagnosed with Atrial Fibrillation?";
	public  final String Q88="88.Prostate cancer?";
	public  final String Q89="89.Colon or rectal cancer?";
	public  final String Q90="90.Diagnosed with any other cancer?";
	public  final String Q91="91.Leukoplakia (precancerous condition of the mouth)?";
	public  final String Q92="92.Are you interested in knowing about scientifically-based nutrition, lifestyle and supplementation practices that can lower your risk of cancer, in general?";
	public  final String Q93="93.Stomach or intestinal ulcers?";
	public  final String Q94="94.Irritable bowel syndrome?";
	public  final String Q95="95.Crohn’s Disease?";
	public  final String Q96="96.Ulcerative Colitis?";
	public  final String Q97="97.Bloating or frequent indigestion after meals?";
	public  final String Q98="98.Heartburn, gastritis or GERD (gastroesophageal reflux disease)?";
	public  final String Q99="99.Diverticulitis or Diverticulosis (Diverticular Disease)";
	public  final String Q100="100.Celiac disease?";
	public  final String Q101="101.Pancreatitis?";
	public  final String Q102="102.Do you tend to have dry skin?";
	public  final String Q103="103.Do you have little bumpy lesions on the back of your elbows or along your forearms, skin, or on your back?";
	public  final String Q104="104.Acne?";
	public  final String Q105="105.Eczema?";
	public  final String Q106="106.Rosacea?";
	public  final String Q107="107.Is your skin frequently exposed to direct sunlight and/or do you use a tanning bed more than once a month?";
	public  final String Q108="108.Toenail or fingernail fungus?";
	public  final String Q109="109.Do you have dark circles under your eyes, have irregular pigmentation, and/or have a dull or poor complexion?";
	public  final String Q110="110.Warts?";
	public  final String Q111="111.Seborrhea or Seborrheic Dermatitis?";
	public  final String Q112="112.Are you interested in knowing about ingestible and topical nutrients proven to slow and/or reverse wrinkles and skin aging?";
	public  final String Q113="113.Non-insulin dependent diabetic or have been diagnosed as a pre-diabetic?";
	public  final String Q114="114.What is your blood glucose level?";
	public  final String Q115="115.Insulin-dependent diabetes?";
	public  final String Q116="116.Underactive thyroid (low thyroid function) and/or have desire to boost thyroid function through nutritional supplementation?";
	public  final String Q117="117.Osteoporosis or osteopenia?";
	public  final String Q118="118.Osteoarthritis or degenerative arthritis?";
	public  final String Q119="119.Rheumatoid arthritis, ankylosing spondylitis, lupus, Reiter’s syndrome or any other rheumatic condition causing joint inflammation?";
	public  final String Q120="120.Multiple Sclerosis?";
	public  final String Q121="121.Parkinson’s disease?";
	public  final String Q122="122.Gout?";
	public  final String Q123="123.Chronic hepatitis, cirrhosis or history of liver infection?";
	public  final String Q124="124. Hayfever or seasonal allergies due to pollen?";
	public  final String Q125="125.Chronic bronchitis, bronchial asthma or chronic sinusitis?";
	public  final String Q126="126.Presently have cataracts?";
	public  final String Q127="127.Macular degeneration of the eye?";
	public  final String Q128="128.Chronic fatigue syndrome, Epstein-Barr or chronic mononucleosis?";
	public  final String Q129="129.Currently have fibromyalgia?";
	public  final String Q130="130.Varicose veins or chronic venous insufficiency?";
	public  final String Q131="131.Frequent constipation?";
	public  final String Q132="132.Scleroderma?";
	public  final String Q133="133.Sarcoidosis?";
	public  final String Q134="134.Do you presently have tendonitis, bursitis or muscle inflammation pain?";
	public  final String Q135="135.Raynaud’s syndrome (disease)?";
	public  final String Q136="136.Restless Leg Syndrome?";
	public  final String Q137="137.Tardive dyskinesia?";
	public  final String Q138="138.Ever been diagnosed with Central Serous Retinopathy?";
	public  final String Q139="139.Chronic Kidney Disease (Chronic Renal Failure)?";
	public  final String Q140="140.Ever been diagnosed with a fatty liver problem from being overweight, excess alcohol consumption or from diabetes?";
	public  final String Q141="141.Personal history of Retinal Tears?";
	public  final String Q142="142.Ever been diagnosed with post-concussion syndrome?";
	public  final String Q143="143.Peripheral Neuropathy from Diabetes, Chemotherapy or a Nerve Injury?";
	public  final String Q144="144.Insomnia and/or interrupted sleep due to night time pain?";
	public  final String Q145="145.Migraine headaches?";
	public  final String Q146="146.Ever been diagnosed with liver damage from using a prescription drug, over-the-counter drug or street drug, or from exposure to a liver toxin?";
	public  final String Q147="147.Ever been diagnosed with a kidney stone?";
	public  final String Q148="148.Intermittent Claudication or Peripheral Vascular Disease?";
	public  final String Q149="149.Insomnia or interrupted sleep, which is not caused by pain?";
	public  final String Q150="150.Tested positive for HIV infection?";
	public  final String Q151="151.Lingering symptoms of Lyme disease that were not managed effectively with antibiotics soon after the initial infection?";
	public  final String Q152="152.Frequent canker sores, cold sores, chronic shingles or other herpes infections?";
	public  final String Q153="153.Been diagnosed with Mild Cognitive Dysfunction?";
	public  final String Q154="154.How many hours do you usually sleep on an average night?";
	public  final String Q155="155.Do you have trouble either falling or staying asleep?";
	public  final String Q156="156.Do you have glaucoma?";
	public  final String Q157="157.Do you have epilepsy?";
	public  final String Q158="158.Do you suffer from recurrent back pain that limits your work and leisure activities for more than 2 days at a time?";
	public  final String Q159="159.Do you have Chronic Obstructive Pulmonary Disease (COPD)?";
	public  final String Q160="160.Do you suffer from chronic or recurrent knee or hip pain?";
	public  final String Q161="161.Do you suffer from prostate gland enlargement (decreased urine stream, frequent night-time urination)?";
	public  final String Q162="162.Are you interested in nutrition and supplementation information directed at enhancing sex drive and/or sexual performance capabilities?";
	public  final String Q163="163.At some point in your life you suffered from anorexia nervosa, bulimia or an eating disorder?";
	public  final String Q164="164.You have undergone treatment with oral glucocorticosteroid (prednisone, cortisone, etc.) drug for more than 3 months at some time in your life?";
	public  final String Q165="165.You have been diagnosed with hyperparathyroidism?";
	public  final String Q166="166.In general, you have poor muscular development and strength?";
	public  final String Q167="167.You have taken anticonvulsant medication for 5 years or longer at some point in your life?";
	public  final String Q168="168.You have rheumatoid arthritis or ankylosing spondylitis?";
	public  final String Q169="169.You take the drug methotrexate (usually for rheumatoid arthritis or cancer)?";
	public  final String Q170="170.You have had a previous fracture in adult years from minimal trauma or had a previous fracture of a vertebra, wrist, hip or pelvis?";
	public  final String Q171="171.You are taking thyroid replacement therapy (thyroid hormone)?";
	public  final String Q172="172.In the last month, have you found you had little interest or pleasure in doing things?";
	public  final String Q173="173.In the last month have you been feeling down, depressed or hopeless?";
	public  final String Q174="174.How would you rate your current stress level?";
	public  final String Q175="175.If you run into problems with your health or other parts of your life, do you have a few friends or family members from whom you can ask for help?";
	public  final String Q176="176.Are you responsible for the care of another person (such as an aging parent, sick family member or a disabled child/adult)?";
	public  final String Q177="177.How would you rate your current relationship with your partner?";
	public  final String Q178="178.How would you rate your current friendships and relationships?";
	public  final String Q179="179.Depression?";
	public  final String Q180="180.Anxiety?";
	public  final String Q181="181.Bipolar?";
	public  final String Q182="182.How often do you miss taking your medications(s)?";
	public  final String Q183="183.Do you sometimes forget to take your pills?";
	public  final String Q184="184.People sometimes miss taking their medications for reasons other than forgetting. Thinking over the past two weeks, were there any days when you did not take your medicine?";
	public  final String Q185="185.Have you ever cut back or stopped taking your medication without telling your doctor?";
	public  final String Q186="186.When you travel or leave home, do you sometimes forget to bring along your medication?";
	public  final String Q187="187.Did you take your medicine yesterday?";
	public  final String Q188="188.When you feel like your condition is under control, do you sometimes stop taking your medicine?";
	public  final String Q189="189.Taking medication everyday is a real inconvenience for some people. Do you ever feel hassled about sticking to your treatment plan?";
	public  final String Q190="190.How often do you have difficulty remembering to take all your medications?";
	public  final String Q191="191.Which of the following best describes your current approach to nutrition and lifestyle practices related to wellness?";
	public  final String Q192="192.Do you get a flu shot every year?";
	public  final String Q193="193.Which of the following best describes your ethnic background?";
	public  final String Q194="194.To what degree does your current health status compromise your quality of life and/or your ability to participate in desired recreational activities?";
	public  final String Q195="195.Have any of your first-degree relatives developed colon cancer?";
	public  final String Q196="196.Have any of your first-degree relatives developed prostate cancer?";
	public  final String Q197="197.Have any of your first-degree relatives developed dementia or Alzheimer’s disease?";
	public  final String Q198="198.Have any of your first-degree relatives developed Parkinson’s disease?";
	public  final String Q199="199.Have any of your first-degree relatives suffered a heart attack before age 60?";
	public  final String Q200="200.Have you ever had an allergic reaction to a vitamin supplement in the past?";
	public  final String Q201="201.Do you suffer from a hemolytic anemia due to glucose-6 phosphate dehydrogenase deficiency?";
	public  final String Q202="202.Do you suffer from kidney failure or are you currently receiving dialysis treatment?";
	public  final String Q203="203.Do you have Wilson’s disease?";
	public  final String Q204="204.Do you have hemochromatosis?";
	public  final String Q205="205.Have you ever received a liver, kidney, heart or lung transplant?";
	public  final String Q206="206.Are you taking an immuno-suppressive drug (i.e., Azathioprine, Cyclosporine, Methotrexate)?";
	public  final String Q207="207.Have you ever been diagnosed with Chrohn’s Disease or Ulcerative Colitis?";
	public  final String Q208="208.Are you an insulin-dependent diabetic?";
	public  final String Q209="209.Do you have only one functioning kidney (due to one kidney being removed or one kidney known to be non-functional?";
	public  final String Q210="210.Are you taking the drug digitalis or digoxin?";
	public  final String Q211="211.Do you have an active ulcer?";
	public  final String Q212="212.Are you presently taking any anti-inflammatory drugs, other than acetaminophen or blood thinners (anti-coagulants)?";
	public  final String Q213="213.Do you have pacemaker?";
	public  final String Q214="214.Are you taking drugs to correct a heart arrhythmia problem?";
	public  final String Q215="215.Are you taking any medications for Alzheimer’s or dementia?";
	public  final String Q216="216.Are you allergic to aspirin?";
	public  final String Q217="217.Do you suffer from hemophilia?";
	public  final String Q218="218.Are you presently experiencing a flare-up of gout (gouty arthritis)?";
	public  final String Q219="219.Do you have advanced liver disease?";
	public  final String Q220="220.Do you suffer from hyperparathyroidism, sarcoidosis, active tuberculosis, silicosis or lymphoma?";
	public  final String Q221="221.Are you taking a drug called Methotrexate?";
	public  final String Q222="222.Are you presently taking any chemotherapy drugs or undergoing radiation therapy for the treatment of cancer?";
	public  final String Q223="223.Are you currently taking any drugs for depression or to treat a psychological disorder of any kind (e.g., bipolar disease, schizophrenia, obsessive-compulsive disorder, etc.)?";
	public  final String Q224="224.Are you taking the drug accutane (usually for acne)?";
	public  final String Q225="225.Are you presently taking a narcotic drug (e.g., Percodan, Percocet, Oxycontin, Oxycodone, Morphine, etc.)?";
	public  final String Q226="226.Are you presently taking an anti-anxiety drug (i.e., benzodiazepine, such as Valium, Ativan, etc.)?";
	public  final String Q227="227.Are you presently taking a sleep-aid medication (e.g., Sonata, Ambien, etc.)?";
	public  final String Q228="228.Are you known to be allergic to morphine or opiod-containing drugs?";
	public  final String Q229="229.Are you taking radioactive iodine to treat thyroid cancer, Grave’s disease or other thyroid disorder?";
	public  final String Q230="230.Are you a diabetic or do you have known blood sugar regulation problems?";
	public  final String Q231="231.Are you taking vitamin K-blocking anti-coagulants (e.g., Coumadin, Warfarin, Jantoven, Marevan, Lawarin, Waran, Warfant)?";
	public  final String Q232="232.Do you have a severe shellfish allergy?";
	public  final String FQ66="66.Oral contraceptives?";
	public  final String FQ67="67.Estrogen Replacement Therapy?";
	public  final String FQ68="66.Cholesterol-lowering Bile Acid Sequestrant drugs?";
	public  final String FQ69="67.Cholesterol-lowering Statin Drugs?";
	public  final String FQ70="68.ACE-inhibitors? (usually prescribed for high blood pressure or diabetics)";
	public  final String FQ71="69.Beta-blockers? (often prescribed for high blood pressure and arrhythmia)";
	public  final String FQ72="70.Digitalis?";
	public  final String FQ73="71.Corticosteroids?";
	public  final String FQ74="72.Indomethacin?";
	public  final String FQ75="73.Diuretics?";
	public  final String FQ76="74.Specific drug for Gout?";
	public  final String FQ77="75.L-dopa for Parkinson’s disease?";
	public  final String FQ78="76.Theophylline?";
	public  final String FQ79="79.Have you been diagnosed with high cholesterol?";
	public  final String FQ80="80.What is your Total Cholesterol level?";
	public  final String FQ81="81.What is your LDL-Cholesterol level?";
	public  final String FQ82="82.What is your HDL-Cholesterol level?";
	public  final String FQ83="83.Do you have a history of heart disease?";
	public  final String FQ84="84.Have you had a previous heart attack?";
	public  final String FQ85="85.Have you had a previous stroke?";
	public  final String FQ86="86.Do you have high triglyceride levels?";
	public  final String FQ87="87.Do you have high blood pressure?";
	public  final String FQ88="88.What is your current Blood Pressure reading?";
	public  final String FQ89="89.Have you been diagnosed with Atrial Fibrillation?";
	public  final String FQ90="90.Breast cancer?";
	public  final String FQ91="91.Colon or rectal cancer?";
	public  final String FQ92="92.Diagnosed with any other cancer?";
	public  final String FQ93="93.Leukoplakia (precancerous condition of the mouth)?";
	public  final String FQ94="94.Are you interested in knowing about scientifically-based nutrition, lifestyle and supplementation practices that can lower your risk of cancer, in general?";
	public  final String FQ95="95.Stomach or intestinal ulcers?";
	public  final String FQ96="96.Irritable bowel syndrome?";
	public  final String FQ97="97.Crohn’s Disease?";
	public  final String FQ98="98.Ulcerative Colitis?";
	public  final String FQ99="99.Bloating or frequent indigestion after meals?";
	public  final String FQ100="100.Heartburn, gastritis or GERD (gastroesophageal reflux disease)?";
	public  final String FQ101="101.Diverticulitis or Diverticulosis (Diverticular Disease)";
	public  final String FQ102="102.Celiac disease?";
	public  final String FQ103="103.Pancreatitis?";
	public  final String FQ104="104.Do you tend to have dry skin?";
	public  final String FQ105="105.Do you have little bumpy lesions on the back of your elbows or along your forearms, skin, or on your back?";
	public  final String FQ106="106.Acne?";
	public  final String FQ107="107.Eczema?";
	public  final String FQ108="108.Rosacea?";
	public  final String FQ109="109.Is your skin frequently exposed to direct sunlight and/or do you use a tanning bed more than once a month?";
	public  final String FQ110="110.Toenail or fingernail fungus?";
	public  final String FQ111="111.Do you have dark circles under your eyes, have irregular pigmentation, and/or have a dull or poor complexion?";
	public  final String FQ112="112.Warts?";
	public  final String FQ113="113.Seborrhea or Seborrheic Dermatitis?";
	public  final String FQ114="114.Are you interested in knowing about ingestible and topical nutrients proven to slow and/or reverse wrinkles and skin aging?";
	public  final String FQ115="115.Non-insulin dependent diabetic or have been diagnosed as a pre-diabetic?";
	public  final String FQ116="116.What is your blood glucose level?";
	public  final String FQ117="117.Insulin-dependent diabetes?";
	public  final String FQ118="118.Underactive thyroid (low thyroid function) and/or have desire to boost thyroid function through nutritional supplementation?";
	public  final String FQ119="119.Osteoporosis or osteopenia?";
	public  final String FQ120="120.Osteoarthritis or degenerative arthritis?";
	public  final String FQ121="121.Rheumatoid arthritis, ankylosing spondylitis, lupus, Reiter’s syndrome or any other rheumatic condition causing joint inflammation?";
	public  final String FQ122="122.Multiple Sclerosis?";
	public  final String FQ123="123.Parkinson’s disease?";
	public  final String FQ124="124.Gout?";
	public  final String FQ125="125.Chronic hepatitis, cirrhosis or history of liver infection?";
	public  final String FQ126="126. Hayfever or seasonal allergies due to pollen?";
	public  final String FQ127="127.Chronic bronchitis, bronchial asthma or chronic sinusitis?";
	public  final String FQ128="128.Presently have cataracts?";
	public  final String FQ129="129.Macular degeneration of the eye?";
	public  final String FQ130="130.Chronic fatigue syndrome, Epstein-Barr or chronic mononucleosis?";
	public  final String FQ131="131.Currently have fibromyalgia?";
	public  final String FQ132="132.Varicose veins or chronic venous insufficiency?";
	public  final String FQ133="133.Frequent constipation?";
	public  final String FQ134="134.Scleroderma?";
	public  final String FQ135="135.Sarcoidosis?";
	public  final String FQ136="136.Do you presently have tendonitis, bursitis or muscle inflammation pain?";
	public  final String FQ137="137.Raynaud’s syndrome (disease)?";
	public  final String FQ138="138.Restless Leg Syndrome?";
	public  final String FQ139="139.Tardive dyskinesia?";
	public  final String FQ140="140.Ever been diagnosed with Central Serous Retinopathy?";
	public  final String FQ141="141.Chronic Kidney Disease (Chronic Renal Failure)?";
	public  final String FQ142="142.Ever been diagnosed with a fatty liver problem from being overweight, excess alcohol consumption or from diabetes?";
	public  final String FQ143="143.Personal history of Retinal Tears?";
	public  final String FQ144="144.Ever been diagnosed with post-concussion syndrome?";
	public  final String FQ145="145.Peripheral Neuropathy from Diabetes, Chemotherapy or a Nerve Injury?";
	public  final String FQ146="146.Insomnia and/or interrupted sleep due to night time pain?";
	public  final String FQ147="147.Migraine headaches?";
	public  final String FQ148="148.Ever been diagnosed with liver damage from using a prescription drug, over-the-counter drug or street drug, or from exposure to a liver toxin?";
	public  final String FQ149="149.Ever been diagnosed with a kidney stone?";
	public  final String FQ150="150.Intermittent Claudication or Peripheral Vascular Disease?";
	public  final String FQ151="151.Insomnia or interrupted sleep, which is not caused by pain?";
	public  final String FQ152="152.Tested positive for HIV infection?";
	public  final String FQ153="153.Lingering symptoms of Lyme disease that were not managed effectively with antibiotics soon after the initial infection?";
	public  final String FQ154="154.Frequent canker sores, cold sores, chronic shingles or other herpes infections?";
	public  final String FQ155="155.Been diagnosed with Mild Cognitive Dysfunction?";
	public  final String FQ156="156.How many hours do you usually sleep on an average night?";
	public  final String FQ157="157.Do you have trouble either falling or staying asleep?";
	public  final String FQ158="158.Do you have glaucoma?";
	public  final String FQ159="159.Do you have epilepsy?";
	public  final String FQ160="160.Do you suffer from recurrent back pain that limits your work and leisure activities for more than 2 days at a time?";
	public  final String FQ161="161.Do you have Chronic Obstructive Pulmonary Disease (COPD)?";
	public  final String FQ162="162.Do you suffer from chronic or recurrent knee or hip pain?";
	public  final String FQ163="163.Experiencing any menopausal or peri-menopausal symptoms (i.e., hot flashes, night sweats, insomnia, skipped periods, irritability, etc.)?";
	public  final String FQ164="164.Suffer from premenstrual syndrome (PMS) or painful menstruation?";
	public  final String FQ165="165.Fibrocystic breast disease?";
	public  final String FQ166="166.Uterine fibroids?";
	public  final String FQ167="167.Endometriosis?";
	public  final String FQ168="168.Cervical dysplasia?";
	public  final String FQ169="169.Recurring bladder or urinary tract infections?";
	public  final String FQ170="170.Are you interested in nutrition and supplementation advice to enhance sex drive and genital sensitivity?";
	public  final String FQ171="171.Do you suffer from severe menstrual cramps (dysmenorrhea)?";
	public  final String FQ172="172.Have you been diagnosed with Polycystic Ovarian Syndrome (PCOS)?";
	public  final String FQ173="173.At some point in your life you suffered from anorexia nervosa, bulimia or an eating disorder?";
	public  final String FQ174="174.You have undergone treatment with oral glucocorticosteroid (prednisone, cortisone, etc.) drug for more than 3 months at some time in your life?";
	public  final String FQ175="175.You have been diagnosed with hyperparathyroidism?";
	public  final String FQ176="176.Your biological mother or sister(s) developed osteoporosis";
	public  final String FQ177="177.In general, you have poor muscular development and strength?";
	public  final String FQ178="178.You have taken anticonvulsant medication for 5 years or longer at some point in your life?";
	public  final String FQ179="179.You have rheumatoid arthritis or ankylosing spondylitis?";
	public  final String FQ180="180.You take the drug methotrexate (usually for rheumatoid arthritis or cancer)?";
	public  final String FQ181="181.You have had a previous fracture in adult years from minimal trauma or had a previous fracture of a vertebra, wrist, hip or pelvis?";
	public  final String FQ182="182.You are taking thyroid replacement therapy (thyroid hormone)?";
	public  final String FQ183="183.In the last month, have you found you had little interest or pleasure in doing things?";
	public  final String FQ184="184.In the last month have you been feeling down, depressed or hopeless?";
	public  final String FQ185="185.How would you rate your current stress level?";
	public  final String FQ186="186.If you run into problems with your health or other parts of your life, do you have a few friends or family members from whom you can ask for help?";
	public  final String FQ187="187.Are you responsible for the care of another person (such as an aging parent, sick family member or a disabled child/adult)?";
	public  final String FQ188="188.How would you rate your current relationship with your partner?";
	public  final String FQ189="189.How would you rate your current friendships and relationships?";
	public  final String FQ190="190.Depression?";
	public  final String FQ191="191.Anxiety?";
	public  final String FQ192="192.Bipolar?";
	public  final String FQ193="193.How often do you miss taking your medications(s)?";
	public  final String FQ194="194.Do you sometimes forget to take your pills?";
	public  final String FQ195="195.People sometimes miss taking their medications for reasons other than forgetting. Thinking over the past two weeks, were there any days when you did not take your medicine?";
	public  final String FQ196="196.Have you ever cut back or stopped taking your medication without telling your doctor?";
	public  final String FQ197="197.When you travel or leave home, do you sometimes forget to bring along your medication?";
	public  final String FQ198="198.Did you take your medicine yesterday?";
	public  final String FQ199="199.When you feel like your condition is under control, do you sometimes stop taking your medicine?";
	public  final String FQ200="200.Taking medication everyday is a real inconvenience for some people. Do you ever feel hassled about sticking to your treatment plan?";
	public  final String FQ201="201.How often do you have difficulty remembering to take all your medications?";
	public  final String FQ202="202.Which of the following best describes your current approach to nutrition and lifestyle practices related to wellness?";
	public  final String FQ203="203.Do you get a flu shot every year?";
	public  final String FQ204="204.Which of the following best describes your ethnic background?";
	public  final String FQ205="205.To what degree does your current health status compromise your quality of life and/or your ability to participate in desired recreational activities?";
	public  final String FQ206="206.Have any of your first-degree relatives developed colon cancer?";
	public  final String FQ207="207.Have any of your first-degree relatives developed breast cancer?";
	public  final String FQ208="208.Have any of your first-degree relatives developed dementia or Alzheimer’s disease?";
	public  final String FQ209="209.Have any of your first-degree relatives developed Parkinson’s disease?";
	public  final String FQ210="210.Have any of your first-degree relatives suffered a heart attack before age 60?";
	public  final String FQ211="211.Have you ever had an allergic reaction to a vitamin supplement in the past?";
	public  final String FQ212="212.Are you pregnant or breast feeding?";
	public  final String FQ213="213.Do you suffer from a hemolytic anemia due to glucose-6 phosphate dehydrogenase deficiency?";
	public  final String FQ214="214.Do you suffer from kidney failure or are you currently receiving dialysis treatment?";
	public  final String FQ215="215.Do you have Wilson’s disease?";
	public  final String FQ216="216.Do you have hemochromatosis?";
	public  final String FQ217="217.Have you ever received a liver, kidney, heart or lung transplant?";
	public  final String FQ218="218.Have you ever been diagnosed with breast or ovarian cancer?";
	public  final String FQ219="219.Are you taking an immuno-suppressive drug (i.e., Azathioprine, Cyclosporine, Methotrexate)?";
	public  final String FQ220="220.Have you ever been diagnosed with Chrohn’s Disease or Ulcerative Colitis?";
	public  final String FQ221="221.Are you an insulin-dependent diabetic?";
	public  final String FQ222="222.Do you have only one functioning kidney (due to one kidney being removed or one kidney known to be non-functional?";
	public  final String FQ223="223.Are you taking the drug digitalis or digoxin?";
	public  final String FQ224="224.Do you have an active ulcer?";
	public  final String FQ225="225.Are you presently taking any anti-inflammatory drugs, other than acetaminophen or blood thinners (anti-coagulants)?";
	public  final String FQ226="226.Do you have pacemaker?";
	public  final String FQ227="227.Are you taking drugs to correct a heart arrhythmia problem?";
	public  final String FQ228="228.Are you taking any medications for Alzheimer’s or dementia?";
	public  final String FQ229="229.Are you allergic to aspirin?";
	public  final String FQ230="230.Do you suffer from hemophilia?";
	public  final String FQ231="231.Are you presently experiencing a flare-up of gout (gouty arthritis)?";
	public  final String FQ232="232.Do you have advanced liver disease?";
	public  final String FQ233="233.Do you suffer from hyperparathyroidism, sarcoidosis, active tuberculosis, silicosis or lymphoma?";
	public  final String FQ234="234.Are you taking a drug called Methotrexate?";
	public  final String FQ235="235.Are you presently taking any chemotherapy drugs or undergoing radiation therapy for the treatment of cancer?";
	public  final String FQ236="236.Are you currently taking any drugs for depression or to treat a psychological disorder of any kind (e.g., bipolar disease, schizophrenia, obsessive-compulsive disorder, etc.)?";
	public  final String FQ237="237.Are you taking the drug accutane (usually for acne)?";
	public  final String FQ238="238.Are you presently taking a narcotic drug (e.g., Percodan, Percocet, Oxycontin, Oxycodone, Morphine, etc.)?";
	public  final String FQ239="239.Are you presently taking an anti-anxiety drug (i.e., benzodiazepine, such as Valium, Ativan, etc.)?";
	public  final String FQ240="240.Are you presently taking a sleep-aid medication (e.g., Sonata, Ambien, etc.)?";
	public  final String FQ241="241.Are you known to be allergic to morphine or opiod-containing drugs?";
	public  final String FQ242="242.Are you taking radioactive iodine to treat thyroid cancer, Grave’s disease or other thyroid disorder?";
	public  final String FQ243="243.Are you a diabetic or do you have known blood sugar regulation problems?";
	public  final String FQ244="244.Are you taking vitamin K-blocking anti-coagulants (e.g., Coumadin, Warfarin, Jantoven, Marevan, Lawarin, Waran, Warfant)?";
	public  final String FQ245="245.Do you have a severe shellfish allergy?";
	
	
	@FindBy(xpath="//select[@id='DDLQ277']")
	WebElement weight_dropdown;
	
	@FindBy(xpath="//select[@id='DDLQ278']")
	WebElement waist_dropdown;
	
	@FindBy(xpath="//a[@href='#next']")
	WebElement nextbutton;
	
	@FindBy(xpath="//a[@id='btnRestart']")
	WebElement restart;
	
	@FindBy(xpath="//a[contains(text(),'Finish')]")
	WebElement finish;
	
	@FindBy(xpath="//input[@id='finishAccept']")
	WebElement acceptcheckbox;
	
	@FindBy(id="confirmConsent")
	WebElement confirmconsent;
	
	public void selectweight(String weight){
	//	System.out.println("weight"+ weight);
	//	String value = weight.substring(0,weight.indexOf("."));
		//findAndWait(weight_dropdown, 20).click();
	//	System.out.println(value);
		Select s = new Select(findAndWait(weight_dropdown, 20));
		
		s.selectByVisibleText(weight);
		
	}
	
	
	public void selectwaist(String waist){
	//	String value = waist.substring(0,waist.indexOf("."));
		//findAndWait(weight_dropdown, 20).click();
		//System.out.println(value);
		Select s = new Select(findAndWait(waist_dropdown, 20));
		
		s.selectByVisibleText(waist);
		
	}
	
	public void clickNext(){
		findAndWait(nextbutton, 40).click();
	}
	
	
	public void clickOnRestart(){
		
		findAndWait(restart, 30).click();
	}
	public boolean isRestart(){
		
		if(driver.findElement(By.xpath("//a[@id='btnRestart']")).isDisplayed())
		{
			
		return true;
		
		}
		else
		{
			
			return false;
		}
	
	}
	
	
	
	public void selectAnswerOption(String QNumber, String AnsOption) {
		
		WebElement e = driver.findElement(By.xpath("//div[@id='Answers"+QNumber+"']"));
		List<WebElement> li = e.findElements(By.tagName("label"));
		for(int i=0;i<li.size();i++){
			if(li.get(i).getText().equalsIgnoreCase(AnsOption)){
				
				try {
					Thread.sleep(500);
				} catch (Throwable t) {
					// TODO Auto-generated catch block
					
					logger.log(Status.ERROR, t.getMessage());
					
				}
				li.get(i).findElement(By.id("rbAnswerNum")).click();
				break;
			}
		}
        
		
	}
	public void clickOnFinish(){
		
		findAndWait(finish, 20).click();
	}
	public void checkConsent(){
		findAndWait(acceptcheckbox, 20).click();
	}

	public MyWellnessReportPage clickConfirm(){
		findAndWait(confirmconsent, 20).click();
		MyWellnessReportPage wrp= new MyWellnessReportPage(driver, logger);
		PageFactory.initElements(driver, wrp);
		return wrp;
	}
	
	public String confirmReport(){
		 if(isElementPresent(MWConstants.REPORT_COMPLETED))
		 {
		    String text = driver.findElement(By.xpath(MWConstants.REPORT_COMPLETED)).getText();
		    
		    return text;
		 }
		 return null;
		
	}
}
