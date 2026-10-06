package com.eduguide.eduguide;

import com.eduguide.eduguide.model.Career;
import com.eduguide.eduguide.model.Course;
import com.eduguide.eduguide.model.Field;
import com.eduguide.eduguide.model.Stream;
import com.eduguide.eduguide.model.Exam;
import com.eduguide.eduguide.model.College;
import com.eduguide.eduguide.model.Scholarship;
import com.eduguide.eduguide.model.Pathway;


import com.eduguide.eduguide.repository.ExamRepository;
import com.eduguide.eduguide.repository.CareerRepository;
import com.eduguide.eduguide.repository.CourseRepository;
import com.eduguide.eduguide.repository.FieldRepository;
import com.eduguide.eduguide.repository.StreamRepository;
import com.eduguide.eduguide.repository.CollegeRepository;
import com.eduguide.eduguide.repository.ScholarshipRepository;
import com.eduguide.eduguide.repository.PathwayRepository;


import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class DataInitializer implements CommandLineRunner {

    private final StreamRepository streamRepository;
    private final FieldRepository fieldRepository;
    private final CourseRepository courseRepository;
    private final CareerRepository careerRepository;
    private final ExamRepository examRepository;
    private final CollegeRepository collegeRepository;
    private final ScholarshipRepository scholarshipRepository;
    private final PathwayRepository pathwayRepository;

    public DataInitializer(StreamRepository streamRepository,
                           FieldRepository fieldRepository,
                           CourseRepository courseRepository,
                           CareerRepository careerRepository,
                           ExamRepository examRepository,
                           CollegeRepository collegeRepository,
                           ScholarshipRepository scholarshipRepository,
                           PathwayRepository pathwayRepository) {

        this.streamRepository = streamRepository;
        this.fieldRepository = fieldRepository;
        this.courseRepository = courseRepository;
        this.careerRepository = careerRepository;
        this.examRepository = examRepository;
        this.collegeRepository = collegeRepository;
        this.scholarshipRepository = scholarshipRepository;
        this.pathwayRepository = pathwayRepository;
    }

    @Override
    @Transactional
    public void run(String... args) {

        // -------------------------------------------------
        // 1. CREATE FIELDS
        // -------------------------------------------------

        if (fieldRepository.count() == 0) {

            fieldRepository.save(new Field(
                    "Engineering",
                    "Engineering and technology related fields"
            ));

            fieldRepository.save(new Field(
                    "Pure Sciences",
                    "Physics, Chemistry, Mathematics and other science fields"
            ));

            fieldRepository.save(new Field(
                    "Architecture",
                    "Architecture and design related fields"
            ));

            fieldRepository.save(new Field(
                    "Computer Applications",
                    "Computer applications and software related fields"
            ));

            fieldRepository.save(new Field(
                    "Medicine",
                    "Medical and healthcare related fields"
            ));

            fieldRepository.save(new Field(
                    "Pharmacy",
                    "Pharmaceutical sciences and healthcare"
            ));

            fieldRepository.save(new Field(
                    "Agriculture",
                    "Agriculture and agricultural sciences"
            ));

            fieldRepository.save(new Field(
                    "Commerce",
                    "Commerce, accounting and business related fields"
            ));

            fieldRepository.save(new Field(
                    "Management",
                    "Business and management related fields"
            ));

            fieldRepository.save(new Field(
                    "Economics",
                    "Economics and economic studies"
            ));

            fieldRepository.save(new Field(
                    "Law",
                    "Legal studies and law related fields"
            ));

            fieldRepository.save(new Field(
                    "Arts and Humanities",
                    "Humanities, languages and social sciences"
            ));

            fieldRepository.save(new Field(
                    "Social Sciences",
                    "Society, politics, psychology and social studies"
            ));

            fieldRepository.save(new Field(
                    "Vocational Studies",
                    "Skill-based and vocational education"
            ));

            System.out.println("Initial field data inserted successfully!");
        }

        // -------------------------------------------------
        // 2. GET STREAMS
        // -------------------------------------------------

        Stream mpc = streamRepository.findAll()
                .stream()
                .filter(s -> s.getName().equals("MPC"))
                .findFirst()
                .orElse(null);

        Stream bipc = streamRepository.findAll()
                .stream()
                .filter(s -> s.getName().equals("BiPC"))
                .findFirst()
                .orElse(null);

        Stream mec = streamRepository.findAll()
                .stream()
                .filter(s -> s.getName().equals("MEC"))
                .findFirst()
                .orElse(null);

        Stream cec = streamRepository.findAll()
                .stream()
                .filter(s -> s.getName().equals("CEC"))
                .findFirst()
                .orElse(null);

        Stream arts = streamRepository.findAll()
                .stream()
                .filter(s -> s.getName().equals("Arts/Humanities"))
                .findFirst()
                .orElse(null);

        Stream vocational = streamRepository.findAll()
                .stream()
                .filter(s -> s.getName().equals("Vocational"))
                .findFirst()
                .orElse(null);

        // -------------------------------------------------
        // 3. GET FIELDS
        // -------------------------------------------------

        Field engineering = getField("Engineering");
        Field pureSciences = getField("Pure Sciences");
        Field architecture = getField("Architecture");
        Field computerApplications = getField("Computer Applications");

        Field medicine = getField("Medicine");
        Field pharmacy = getField("Pharmacy");
        Field agriculture = getField("Agriculture");

        Field commerce = getField("Commerce");
        Field management = getField("Management");
        Field economics = getField("Economics");

        Field law = getField("Law");
        Field artsHumanities = getField("Arts and Humanities");
        Field socialSciences = getField("Social Sciences");

        Field vocationalStudies = getField("Vocational Studies");

        // -------------------------------------------------
        // 4. CONNECT STREAMS WITH FIELDS
        // -------------------------------------------------

        if (mpc != null) {

            mpc.getFields().add(engineering);
            mpc.getFields().add(pureSciences);
            mpc.getFields().add(architecture);
            mpc.getFields().add(computerApplications);

            streamRepository.save(mpc);
        }

        if (bipc != null) {

            bipc.getFields().add(medicine);
            bipc.getFields().add(pharmacy);
            bipc.getFields().add(agriculture);
            bipc.getFields().add(pureSciences);

            streamRepository.save(bipc);
        }

        if (mec != null) {

            mec.getFields().add(commerce);
            mec.getFields().add(economics);
            mec.getFields().add(management);

            streamRepository.save(mec);
        }

        if (cec != null) {

            cec.getFields().add(commerce);
            cec.getFields().add(economics);
            cec.getFields().add(management);
            cec.getFields().add(law);

            streamRepository.save(cec);
        }

        if (arts != null) {

            arts.getFields().add(artsHumanities);
            arts.getFields().add(socialSciences);
            arts.getFields().add(economics);
            arts.getFields().add(law);

            streamRepository.save(arts);
        }

        if (vocational != null) {

            vocational.getFields().add(vocationalStudies);

            streamRepository.save(vocational);
        }

        System.out.println("Stream-field relationships created successfully!");

        // -------------------------------------------------
        // 5. CREATE INITIAL ENGINEERING COURSES
        // -------------------------------------------------

        
// MPC - Engineering

saveCourseIfMissing(
        "Computer Science Engineering",
        "Learn programming, software development, databases, algorithms and modern computing technologies to build real-world software solutions.",
        "4 Years",
        "10+2 with Mathematics and Physics, with other requirements depending on the institution.",
        engineering
);

saveCourseIfMissing(
        "Information Technology",
        "Focus on software, information systems, databases, networking and digital technologies used to develop IT solutions.",
        "4 Years",
        "10+2 with Mathematics and Physics, subject to institution requirements.",
        engineering
);

saveCourseIfMissing(
        "Electronics and Communication Engineering",
        "Explore electronics, communication systems, embedded systems, signal processing and modern communication technologies.",
        "4 Years",
        "10+2 with Physics and Mathematics, with institution-specific requirements.",
        engineering
);

saveCourseIfMissing(
        "Mechanical Engineering",
        "Learn about machines, manufacturing, thermodynamics, mechanical systems, design and industrial technology.",
        "4 Years",
        "10+2 with Physics and Mathematics, subject to institution requirements.",
        engineering
);


// MPC - Architecture

saveCourseIfMissing(
        "B.Arch",
        "Learn architectural design, building planning, construction technology and computer-aided design to create functional and sustainable spaces.",
        "5 Years",
        "10+2 with the subjects and requirements prescribed by the architecture institution and applicable admission rules.",
        architecture
);


// MPC - Computer Applications

saveCourseIfMissing(
        "BCA",
        "Learn programming, databases, web development, software applications and computer fundamentals for technology-oriented careers.",
        "3–4 Years",
        "10+2; subject requirements vary by institution. Some institutions require Mathematics.",
        computerApplications
);


// Pure Sciences

saveCourseIfMissing(
        "B.Sc Mathematics",
        "Build strong foundations in mathematics, logical reasoning, statistics and quantitative problem solving.",
        "3 Years",
        "10+2 with Mathematics, subject to institution requirements.",
        pureSciences
);

saveCourseIfMissing(
        "B.Sc Physics",
        "Explore matter, energy, mechanics, electricity, electronics and the fundamental principles behind the physical world.",
        "3 Years",
        "10+2 with relevant science subjects, typically including Physics and Mathematics.",
        pureSciences
);

saveCourseIfMissing(
        "B.Sc Chemistry",
        "Study chemical reactions, materials, laboratory techniques, organic chemistry and the science behind everyday substances.",
        "3 Years",
        "10+2 with relevant science subjects, typically including Chemistry.",
        pureSciences
);

saveCourseIfMissing(
        "B.Sc Biology",
        "Explore living organisms, genetics, ecology, cell biology and biological processes through theory and laboratory learning.",
        "3 Years",
        "10+2 with Biology and relevant science subjects.",
        pureSciences
);

saveCourseIfMissing(
        "B.Sc Biotechnology",
        "Combine biology and technology to study genetics, molecular biology, biotechnology techniques and their applications.",
        "3–4 Years",
        "10+2 with relevant science subjects, typically Biology or related subjects.",
        pureSciences
);


// BiPC - Medicine

saveCourseIfMissing(
        "MBBS",
        "Study human anatomy, physiology, diseases, diagnosis and treatment while developing clinical and patient-care skills.",
        "About 5.5 Years including internship",
        "10+2 with Physics, Chemistry, Biology/Biotechnology and English, along with applicable medical admission requirements.",
        medicine
);


// BiPC - Pharmacy

saveCourseIfMissing(
        "B.Pharm",
        "Learn about medicines, drug formulation, pharmacology, pharmaceutical chemistry, quality control and safe use of medicines.",
        "4 Years",
        "10+2 with Physics and Chemistry and Mathematics/Biology, subject to applicable pharmacy admission rules.",
        pharmacy
);

saveCourseIfMissing(
        "D.Pharm",
        "A practical pharmacy programme covering medicines, dispensing, pharmaceutical sciences and basic patient-care support.",
        "2 Years",
        "10+2 with Physics, Chemistry and Biology/Mathematics or an accepted equivalent qualification.",
        pharmacy
);


// BiPC - Agriculture

saveCourseIfMissing(
        "B.Sc Agriculture",
        "Learn crop science, soil management, agricultural technology, plant protection and modern farming practices.",
        "4 Years",
        "10+2 with relevant science or agriculture subjects, depending on the institution.",
        agriculture
);


// MEC / CEC - Commerce

saveCourseIfMissing(
        "B.Com",
        "Learn accounting, taxation, business law, finance, economics and business operations.",
        "3 Years",
        "10+2; Commerce or relevant subjects may be preferred or required depending on the institution.",
        commerce
);


// MEC / CEC / Arts - Economics

saveCourseIfMissing(
        "B.A Economics",
        "Understand markets, money, development, public policy and how economic decisions affect individuals and society.",
        "3 Years",
        "10+2 from a recognized board, subject to institution requirements.",
        economics
);

saveCourseIfMissing(
        "B.Sc Economics",
        "Combine economics with quantitative and analytical methods to understand markets, data and economic decision-making.",
        "3 Years",
        "10+2 with subjects specified by the institution.",
        economics
);


// MEC / CEC - Management

saveCourseIfMissing(
        "BBA",
        "Learn business management, marketing, finance, human resources, operations and entrepreneurship.",
        "3–4 Years",
        "10+2 from a recognized board; specific subject and percentage requirements vary by institution.",
        management
);


// CEC / Arts - Law

saveCourseIfMissing(
        "BA LLB",
        "Combine legal education with humanities subjects such as political science, economics, history and sociology.",
        "5 Years",
        "10+2 or equivalent; minimum marks and admission requirements depend on the institution or entrance examination.",
        law
);

saveCourseIfMissing(
        "BBA LLB",
        "Combine law with business and management education for students interested in corporate and commercial legal careers.",
        "5 Years",
        "10+2 or equivalent; specific marks and admission requirements vary by institution.",
        law
);


// Arts and Humanities

saveCourseIfMissing(
        "BA",
        "Explore subjects such as history, political science, languages, literature, philosophy and other humanities disciplines.",
        "3 Years",
        "10+2 from a recognized board, subject to institution requirements.",
        artsHumanities
);


// Arts - Social Sciences

saveCourseIfMissing(
        "BA Psychology",
        "Study human behaviour, emotions, cognition, personality and psychological processes.",
        "3 Years",
        "10+2 from a recognized board, subject to institution requirements.",
        socialSciences
);

saveCourseIfMissing(
        "BA Sociology",
        "Understand society, communities, social behaviour, institutions and social change.",
        "3 Years",
        "10+2 from a recognized board, subject to institution requirements.",
        socialSciences
);


// Vocational Studies

saveCourseIfMissing(
        "Diploma in Computer Applications",
        "Develop practical skills in computer applications, office tools, basic programming and digital technologies.",
        "1–2 Years",
        "Usually 10+2 or equivalent; requirements vary by institution.",
        vocationalStudies
);

saveCourseIfMissing(
        "Diploma in Web Development",
        "Learn HTML, CSS, JavaScript, web design and practical website development skills.",
        "1–2 Years",
        "Usually 10+2 or equivalent; institution-specific requirements apply.",
        vocationalStudies
);

saveCourseIfMissing(
        "Diploma in Graphic Design",
        "Develop practical skills in visual communication, digital design, image editing and creative design tools.",
        "1–2 Years",
        "Usually 10+2 or equivalent.",
        vocationalStudies
);

saveCourseIfMissing(
        "Diploma in Hospitality Management",
        "Learn practical skills in hospitality operations, food service, customer service and hotel management.",
        "1–2 Years",
        "Usually 10+2 or equivalent.",
        vocationalStudies
);

saveCourseIfMissing(
        "Diploma in Medical Laboratory Technology",
        "Learn laboratory procedures, sample handling, basic diagnostic testing and healthcare laboratory practices.",
        "2 Years",
        "Typically 10+2 with relevant science subjects; requirements vary by institution.",
        vocationalStudies
);

System.out.println("Complete course data initialized successfully!");

        // -------------------------------------------------
        // 6. CREATE CAREER DATA
        // -------------------------------------------------

        if (careerRepository.count() == 0) {

            Career softwareEngineer = new Career(
                    "Software Engineer",
                    "Computer Science / Engineering",
                    "MPC",
                    "B.Tech / B.E. in Computer Science or related field",
                    "Software Engineers design, develop, test and maintain software applications and systems.",
                    "Java, Python, Data Structures, Algorithms, SQL, Git and problem solving",
                    "Software development, backend development, frontend development, mobile applications and cloud technologies"
            );

            careerRepository.save(softwareEngineer);

            Career dataScientist = new Career(
                    "Data Scientist",
                    "Computer Science / Data Science",
                    "MPC",
                    "B.Tech / B.Sc. / BCA with relevant data science skills",
                    "Data Scientists use data, statistics and machine learning techniques to solve real-world problems.",
                    "Python, Statistics, SQL, Machine Learning, Pandas, NumPy and Data Visualization",
                    "Data science, analytics, machine learning and artificial intelligence"
            );

            careerRepository.save(dataScientist);

            Career doctor = new Career(
                    "Doctor",
                    "Medicine",
                    "BiPC",
                    "MBBS followed by further specialization if desired",
                    "Doctors diagnose illnesses, provide treatment and help patients maintain and improve their health.",
                    "Medical knowledge, communication, decision making, observation and patient care",
                    "Hospitals, clinics, healthcare organizations, research and specialization"
            );

            careerRepository.save(doctor);

            Career pharmacist = new Career(
                    "Pharmacist",
                    "Pharmacy",
                    "BiPC",
                    "B.Pharm / D.Pharm",
                    "Pharmacists work with medicines, their preparation, safe use and appropriate dispensing.",
                    "Pharmaceutical knowledge, chemistry, communication and attention to detail",
                    "Hospitals, pharmacies, pharmaceutical companies, research and quality control"
            );

            careerRepository.save(pharmacist);

            Career civilEngineer = new Career(
                    "Civil Engineer",
                    "Engineering",
                    "MPC",
                    "B.Tech / B.E. in Civil Engineering",
                    "Civil Engineers plan, design and supervise infrastructure such as buildings, roads and bridges.",
                    "Engineering mathematics, CAD, structural concepts, planning and project management",
                    "Construction, infrastructure, structural engineering, transportation and government projects"
            );

            careerRepository.save(civilEngineer);

            Career businessAnalyst = new Career(
                    "Business Analyst",
                    "Management / Commerce",
                    "MEC / CEC",
                    "B.Com / BBA / Engineering or related degree with analytical skills",
                    "Business Analysts study business requirements, processes and data to help organizations make better decisions.",
                    "Data analysis, Excel, SQL, communication, problem solving and business understanding",
                    "Business analysis, consulting, product management, operations and analytics"
            );

            careerRepository.save(businessAnalyst);

            System.out.println("Career data inserted successfully!");
        }
        // -------------------------------------------------
// 7. CREATE EXAM DATA
// -------------------------------------------------

if (examRepository.count() == 0) {

    Exam jeeMain = new Exam(
            "JEE Main",
            "National Testing Agency (NTA)",
            "MPC",
            "10+2 with Physics and Mathematics",
            "National",
            "Engineering entrance examination for admission to undergraduate engineering programs.",
            "Admission to NITs, IIITs and other participating engineering institutions.",
            "https://jeemain.nta.nic.in/"
    );

    examRepository.save(jeeMain);


    Exam neet = new Exam(
            "NEET UG",
            "National Testing Agency (NTA)",
            "BiPC",
            "10+2 with Physics, Chemistry and Biology",
            "National",
            "National entrance examination for undergraduate medical education.",
            "Admission to MBBS, BDS and other medical and allied health programs.",
            "https://neet.nta.nic.in/"
    );

    examRepository.save(neet);


    Exam apEapcet = new Exam(
            "AP EAPCET",
            "Jawaharlal Nehru Technological University, Kakinada",
            "MPC / BiPC",
            "10+2 with the required subjects",
            "State",
            "Andhra Pradesh state-level entrance examination for engineering, agriculture and pharmacy programs.",
            "Admission to participating colleges in Andhra Pradesh.",
            "https://cets.apsche.ap.gov.in/"
    );

    examRepository.save(apEapcet);


    Exam cuet = new Exam(
            "CUET UG",
            "National Testing Agency (NTA)",
            "MPC / BiPC / MEC / CEC / Arts",
            "10+2 or equivalent qualification",
            "National",
            "Common entrance examination used by participating universities for undergraduate admissions.",
            "Admission to undergraduate programs in participating universities.",
            "https://cuet.nta.nic.in/"
    );

    examRepository.save(cuet);


    Exam clat = new Exam(
            "CLAT",
            "Consortium of National Law Universities",
            "CEC / Arts / All Streams",
            "10+2 or equivalent qualification",
            "National",
            "Common Law Admission Test for admission to undergraduate law programs.",
            "Admission to participating National Law Universities and other institutions.",
            "https://consortiumofnlus.ac.in/"
    );

    examRepository.save(clat);


    Exam nata = new Exam(
            "NATA",
            "Council of Architecture",
            "MPC",
            "10+2 with Mathematics",
            "National",
            "Aptitude examination for admission to undergraduate architecture programs.",
            "Admission to participating architecture institutions.",
            "https://www.nata.in/"
    );

    examRepository.save(nata);


    System.out.println("Exam data inserted successfully!");
}
if (collegeRepository.count() == 0) {

    College iitHyderabad = new College(
            "IIT Hyderabad",
            "Sangareddy, Telangana",
            "Institute of National Importance",
            "Telangana",
            "Indian Institute of Technology Hyderabad offers undergraduate, postgraduate and research programs in engineering, science and related disciplines.",
            "B.Tech, M.Tech, M.Sc, Ph.D",
            "https://iith.ac.in/"
    );
    collegeRepository.save(iitHyderabad);


    College nitWarangal = new College(
            "NIT Warangal",
            "Warangal, Telangana",
            "Institute of National Importance",
            "Telangana",
            "National Institute of Technology Warangal offers undergraduate, postgraduate and research programs in engineering, science and management.",
            "B.Tech, M.Tech, MBA, M.Sc, Ph.D",
            "https://www.nitw.ac.in/"
    );
    collegeRepository.save(nitWarangal);


    College andhraUniversity = new College(
            "Andhra University",
            "Visakhapatnam, Andhra Pradesh",
            "Public University",
            "Andhra Pradesh",
            "Andhra University offers undergraduate, postgraduate and research programs across engineering, science, commerce, arts and other disciplines.",
            "B.Tech, B.Sc, B.Com, M.Tech, M.Sc, MBA, Ph.D",
            "https://www.andhrauniversity.edu.in/"
    );
    collegeRepository.save(andhraUniversity);


    College jntuKakinada = new College(
            "JNTU Kakinada",
            "Kakinada, Andhra Pradesh",
            "Public University",
            "Andhra Pradesh",
            "Jawaharlal Nehru Technological University Kakinada offers programs in engineering, technology, management, pharmacy and related disciplines.",
            "B.Tech, M.Tech, MBA, MCA, B.Pharm, M.Pharm",
            "https://jntuk.edu.in/"
    );
    collegeRepository.save(jntuKakinada);


    College osmaniaUniversity = new College(
            "Osmania University",
            "Hyderabad, Telangana",
            "Public University",
            "Telangana",
            "Osmania University offers undergraduate, postgraduate and research programs across arts, science, commerce, engineering, law and other disciplines.",
            "B.A, B.Sc, B.Com, B.E, M.A, M.Sc, MBA, Ph.D",
            "https://www.osmania.ac.in/"
    );
    collegeRepository.save(osmaniaUniversity);


    College svUniversity = new College(
            "Sri Venkateswara University",
            "Tirupati, Andhra Pradesh",
            "Public University",
            "Andhra Pradesh",
            "Sri Venkateswara University offers undergraduate, postgraduate and research programs across science, arts, commerce, management and related disciplines.",
            "B.Sc, B.A, B.Com, M.Sc, M.A, MBA, Ph.D",
            "https://svuniversity.edu.in/"
    );
    collegeRepository.save(svUniversity);


    System.out.println("College data inserted successfully!");
}
if (scholarshipRepository.count() == 0) {

    Scholarship centralSector = new Scholarship(
            "Central Sector Scheme of Scholarship",
            "Government of India",
            "Meritorious students pursuing higher education with applicable income and academic criteria.",
            "Merit",
            "Up to ₹20,000 per year",
            "Scholarship support for meritorious students pursuing undergraduate and postgraduate studies.",
            "https://scholarships.gov.in/"
    );
    scholarshipRepository.save(centralSector);


    Scholarship postMatric = new Scholarship(
            "Post Matric Scholarship",
            "Government Scholarship Portal",
            "Students belonging to eligible categories pursuing studies after Class 10, subject to applicable criteria.",
            "Post-Matric",
            "Varies by scheme",
            "Financial assistance for eligible students pursuing post-matriculation education.",
            "https://scholarships.gov.in/"
    );
    scholarshipRepository.save(postMatric);


    Scholarship pragati = new Scholarship(
            "AICTE Pragati Scholarship",
            "AICTE",
            "Eligible girl students pursuing technical education, subject to applicable AICTE criteria.",
            "Women in Technical Education",
            "As per current scheme guidelines",
            "Financial support intended to encourage girls pursuing technical education.",
            "https://www.aicte-india.org/"
    );
    scholarshipRepository.save(pragati);


    Scholarship saksham = new Scholarship(
            "AICTE Saksham Scholarship",
            "AICTE",
            "Eligible students with specified disabilities pursuing technical education, subject to scheme criteria.",
            "Disability Support",
            "As per current scheme guidelines",
            "Scholarship support for eligible students with disabilities pursuing technical education.",
            "https://www.aicte-india.org/"
    );
    scholarshipRepository.save(saksham);


    Scholarship reliance = new Scholarship(
            "Reliance Foundation Scholarship",
            "Reliance Foundation",
            "Eligible undergraduate students meeting the scholarship's academic and other selection criteria.",
            "Merit",
            "As per current scholarship guidelines",
            "Financial assistance and support for selected undergraduate students.",
            "https://www.reliancefoundation.org/"
    );
    scholarshipRepository.save(reliance);


    Scholarship nsp = new Scholarship(
            "National Scholarship Portal Opportunities",
            "Government of India",
            "Eligibility depends on the specific scholarship scheme and student category.",
            "Multiple Categories",
            "Varies by scheme",
            "A central platform through which students can discover and apply for eligible government scholarship schemes.",
            "https://scholarships.gov.in/"
    );
    scholarshipRepository.save(nsp);


    System.out.println("Scholarship data inserted successfully!");
}

pathwayRepository.deleteAll();
if (pathwayRepository.count() == 0) {

    Pathway p1 = new Pathway(
            "+2",
            "MPC",
            "Stream",
            "MPC is a science stream focused mainly on Mathematics, Physics and Chemistry. It is a common starting point for students interested in engineering, architecture, physical sciences and technology.",
            "2 years",
            "Students who have completed the required secondary education and choose Mathematics, Physics and Chemistry.",
            "Mathematics, logical reasoning, problem solving, basic scientific understanding",
            "Engineering, Architecture, Physical Sciences, Technology and related fields",
            "B.Tech, B.Arch, B.Sc, M.Tech, M.Sc and other higher studies",
            "Engineering aspirant, Architect, Scientist, Technology professional",
            "JEE Main, AP EAPCET, NATA and other applicable examinations",
            "IITs, NITs, IIITs, state universities and other recognized institutions",
            "MPC provides a broad foundation for technical and science-oriented careers."
    );
    pathwayRepository.save(p1);


    Pathway p2 = new Pathway(
            "+2",
            "BiPC",
            "Stream",
            "BiPC focuses on Biology, Physics and Chemistry and is commonly chosen by students interested in medicine, pharmacy, healthcare and biological sciences.",
            "2 years",
            "Students who have completed the required secondary education and choose Biology, Physics and Chemistry.",
            "Biology, observation, scientific reasoning, communication and analytical thinking",
            "Medicine, Pharmacy, Biotechnology, Life Sciences and Healthcare",
            "MBBS, BDS, B.Pharm, B.Sc, M.Sc and other health or science programs",
            "Doctor, Pharmacist, Biotechnologist, Researcher and Healthcare professional",
            "NEET UG, AP EAPCET and other applicable entrance examinations",
            "Medical colleges, pharmacy colleges, universities and recognized healthcare institutions",
            "BiPC can lead to several healthcare, pharmaceutical and life-science career pathways."
    );
    pathwayRepository.save(p2);


    Pathway p3 = new Pathway(
            "+2",
            "MEC",
            "Stream",
            "MEC combines Mathematics, Economics and Commerce-oriented learning. It can provide a foundation for management, finance, business and analytical careers.",
            "2 years",
            "Students who choose Mathematics, Economics and Commerce-related subjects at the senior secondary level.",
            "Numerical ability, analytical thinking, communication, financial awareness",
            "Management, Finance, Business, Banking, Economics and Analytics",
            "BBA, B.Com, Economics, MBA, M.Com and related programs",
            "Business Analyst, Financial Analyst, Accountant, Manager and Entrepreneur",
            "CUET UG and other applicable university or state entrance examinations",
            "Universities, management institutes, commerce colleges and business schools",
            "MEC provides flexibility for students interested in business and analytical careers."
    );
    pathwayRepository.save(p3);


    Pathway p4 = new Pathway(
            "+2",
            "CEC",
            "Stream",
            "CEC focuses on subjects such as Civics, Economics and Commerce and can prepare students for careers in management, law, commerce, public administration and related areas.",
            "2 years",
            "Students who choose Commerce, Economics and Civics-related subjects at the senior secondary level.",
            "Communication, analytical thinking, general awareness, business understanding",
            "Management, Commerce, Law, Public Administration and Business",
            "BBA, B.Com, BA, LLB, MBA, M.Com and related programs",
            "Business Analyst, Manager, Lawyer, Accountant and Public Administration professional",
            "CLAT, CUET UG and other applicable entrance examinations",
            "Universities, law universities, commerce colleges and management institutions",
            "CEC offers multiple pathways across business, law, commerce and public-service-oriented careers."
    );
    pathwayRepository.save(p4);


    Pathway p5 = new Pathway(
            "MPC",
            "Engineering",
            "Field",
            "Engineering applies mathematics and scientific principles to design, build and improve technologies, systems and infrastructure.",
            "Typically 4 years for undergraduate engineering",
            "Usually 10+2 with Mathematics and Physics along with the required subjects.",
            "Mathematics, programming, problem solving, analytical thinking and technical fundamentals",
            "Software, Electronics, Mechanical, Civil, Electrical, AI and other engineering sectors",
            "B.Tech, M.Tech, MS, MBA and specialized certifications",
            "Software Engineer, Civil Engineer, Mechanical Engineer, Electrical Engineer, Data Engineer",
            "JEE Main, AP EAPCET and other applicable engineering entrance examinations",
            "IITs, NITs, IIITs, JNTUs, state universities and other engineering colleges",
            "Engineering provides a wide range of technical and industry career opportunities."
    );
    pathwayRepository.save(p5);


    Pathway p6 = new Pathway(
            "MPC",
            "Architecture",
            "Field",
            "Architecture combines mathematics, design and creativity to plan buildings, spaces and environments.",
            "Typically 5 years for B.Arch",
            "10+2 with Mathematics and other requirements specified by the institution or applicable regulations.",
            "Drawing, spatial reasoning, creativity, mathematics, design and communication",
            "Architecture firms, construction, urban planning, interior and design-related industries",
            "B.Arch, M.Arch, urban planning and other design-related higher studies",
            "Architect, Urban Planner, Architectural Designer, Interior Design professional",
            "NATA and other applicable architecture admission routes",
            "Architecture colleges, universities and recognized institutions",
            "Architecture offers opportunities for students interested in design, construction and the built environment."
    );
    pathwayRepository.save(p6);


    Pathway p7 = new Pathway(
            "BiPC",
            "Medicine",
            "Field",
            "Medicine focuses on understanding diseases, diagnosing conditions, treating patients and improving human health.",
            "Typically 5.5 years for MBBS including internship",
            "10+2 with the required Physics, Chemistry and Biology subjects and applicable admission requirements.",
            "Biology, communication, observation, empathy, decision making and scientific reasoning",
            "Hospitals, clinics, healthcare organizations, research and medical institutions",
            "MD, MS, postgraduate medical specialties and research programs",
            "Doctor, Medical Officer, Clinical professional, Medical Researcher",
            "NEET UG and applicable postgraduate medical entrance routes",
            "Government and private medical colleges, teaching hospitals and recognized institutions",
            "Medicine offers long-term professional opportunities across clinical care, specialization and research."
    );
    pathwayRepository.save(p7);


    Pathway p8 = new Pathway(
            "BiPC",
            "Pharmacy",
            "Field",
            "Pharmacy focuses on medicines, drug development, formulation, quality control and the safe use of pharmaceutical products.",
            "Typically 4 years for B.Pharm",
            "10+2 with the required science subjects and applicable admission requirements.",
            "Chemistry, biology, pharmaceutical knowledge, analytical thinking and attention to detail",
            "Pharmaceutical companies, hospitals, research, quality control and regulatory sectors",
            "M.Pharm, Pharm.D, MBA and pharmaceutical research programs",
            "Pharmacist, Clinical Research Associate, Quality Analyst, Production professional",
            "AP EAPCET, NEET or other applicable admission routes depending on the program",
            "Pharmacy colleges, universities and pharmaceutical institutions",
            "Pharmacy provides opportunities across healthcare, medicines, research and pharmaceutical industries."
    );
    pathwayRepository.save(p8);


    Pathway p9 = new Pathway(
            "MEC",
            "Management",
            "Field",
            "Management involves planning, organizing and leading business activities, people and resources to achieve organizational goals.",
            "Typically 3 years for undergraduate study",
            "10+2 or equivalent qualification with requirements specified by the chosen institution.",
            "Communication, leadership, analytical thinking, teamwork, business awareness",
            "Companies, startups, banking, consulting, marketing, finance and operations",
            "MBA, M.Com, specialized management programs and professional certifications",
            "Business Analyst, Management Trainee, Marketing Executive, Operations Executive",
            "CUET UG and other university or institution-specific admission routes",
            "Universities, business schools, commerce colleges and management institutes",
            "Management provides flexibility to work across many industries and business functions."
    );
    pathwayRepository.save(p9);


    Pathway p10 = new Pathway(
            "CEC",
            "Management",
            "Field",
            "Management provides students with knowledge of business operations, organizational behavior, marketing, finance and decision making.",
            "Typically 3 years for undergraduate study",
            "10+2 or equivalent qualification with applicable institutional requirements.",
            "Communication, leadership, teamwork, business analysis and decision making",
            "Management, marketing, finance, operations, consulting and entrepreneurship",
            "MBA, M.Com and specialized management programs",
            "Business Analyst, HR Executive, Marketing Executive, Operations Executive",
            "CUET UG and other applicable university entrance routes",
            "Universities, management institutes and commerce colleges",
            "Management skills are transferable across many industries and business sectors."
    );
    pathwayRepository.save(p10);


    Pathway p11 = new Pathway(
            "Engineering",
            "B.Tech",
            "Course",
            "B.Tech is an undergraduate engineering program where students specialize in an engineering discipline and develop technical and problem-solving skills.",
            "Typically 4 years",
            "Usually 10+2 with Physics and Mathematics and the required admission criteria.",
            "Programming, mathematics, problem solving, technical concepts, communication and teamwork",
            "Technology companies, engineering industries, startups, manufacturing, infrastructure and research",
            "M.Tech, MS, MBA, research programs and professional certifications",
            "Software Engineer, Data Engineer, Civil Engineer, Mechanical Engineer and other engineering roles",
            "JEE Main, AP EAPCET and other applicable engineering entrance examinations",
            "IITs, NITs, IIITs, JNTUs and other recognized engineering colleges",
            "B.Tech can lead to diverse technical careers depending on specialization and skills."
    );
    pathwayRepository.save(p11);


    Pathway p12 = new Pathway(
            "Architecture",
            "B.Arch",
            "Course",
            "B.Arch is an undergraduate architecture program covering architectural design, building technology, planning and related subjects.",
            "Typically 5 years",
            "10+2 with Mathematics and applicable architecture admission requirements.",
            "Design, drawing, spatial visualization, CAD, creativity and communication",
            "Architecture firms, construction, urban planning, interior design and real-estate sectors",
            "M.Arch, urban planning, design and related postgraduate programs",
            "Architect, Architectural Designer, Urban Planner, Design Consultant",
            "NATA and other applicable admission routes",
            "Architecture colleges and universities recognized by the relevant authorities",
            "B.Arch combines technical knowledge with creativity and design thinking."
    );
    pathwayRepository.save(p12);


    Pathway p13 = new Pathway(
            "Medicine",
            "MBBS",
            "Course",
            "MBBS is the primary undergraduate medical degree that prepares students for professional medical practice.",
            "Typically 5.5 years including internship",
            "10+2 with Physics, Chemistry and Biology and qualification through the applicable admission process.",
            "Medical science, clinical reasoning, communication, empathy and decision making",
            "Hospitals, clinics, public health, research and healthcare organizations",
            "MD, MS, postgraduate specialties, public health and medical research",
            "Doctor, Medical Officer, Clinical professional and healthcare roles",
            "NEET UG for undergraduate medical admission",
            "Government and private medical colleges and teaching hospitals",
            "MBBS provides the foundation for clinical practice and further medical specialization."
    );
    pathwayRepository.save(p13);


    Pathway p14 = new Pathway(
            "Pharmacy",
            "B.Pharm",
            "Course",
            "B.Pharm is an undergraduate program covering pharmaceutical sciences, medicines, drug formulation and healthcare-related applications.",
            "Typically 4 years",
            "10+2 with required science subjects and applicable admission requirements.",
            "Pharmaceutical sciences, chemistry, biology, quality analysis and communication",
            "Pharmaceutical companies, hospitals, research, quality assurance and regulatory organizations",
            "M.Pharm, Pharm.D, MBA and pharmaceutical research programs",
            "Pharmacist, Quality Analyst, Clinical Research Associate, Production professional",
            "AP EAPCET and other applicable admission routes",
            "Pharmacy colleges, universities and pharmaceutical institutions",
            "B.Pharm provides opportunities across healthcare, pharmaceutical manufacturing and research."
    );
    pathwayRepository.save(p14);


    Pathway p15 = new Pathway(
            "Management",
            "BBA",
            "Course",
            "BBA is an undergraduate business program covering management, marketing, finance, human resources, operations and entrepreneurship.",
            "Typically 3 years",
            "10+2 or equivalent qualification with applicable institutional requirements.",
            "Communication, business analysis, teamwork, leadership and presentation skills",
            "Corporate organizations, startups, consulting, marketing, finance and operations",
            "MBA, specialized management programs and professional certifications",
            "Business Analyst, Management Trainee, Marketing Executive, HR Executive",
            "CUET UG and institution-specific admission routes",
            "Universities, business schools and management colleges",
            "BBA provides a foundation for business careers and further management education."
    );
    pathwayRepository.save(p15);


    Pathway p16 = new Pathway(
            "B.Tech",
            "Software Engineer",
            "Career",
            "Software engineering involves designing, developing, testing and maintaining software applications and systems.",
            "Career entry after undergraduate study",
            "A relevant technical degree or equivalent skills and practical programming ability are commonly expected.",
            "Java, Python, JavaScript, SQL, Data Structures, Git, problem solving and system fundamentals",
            "IT companies, product companies, startups, fintech, healthcare technology and many other industries",
            "M.Tech, MS, MBA, specialized cloud, data or software certifications",
            "Software Engineer, Backend Developer, Full Stack Developer, Application Developer",
            "Recruitment may involve coding assessments, technical interviews and company-specific processes",
            "Engineering colleges and universities offering relevant computer science and technology programs",
            "Strong programming fundamentals and continuous learning can create opportunities across the software industry."
    );
    pathwayRepository.save(p16);


    Pathway p17 = new Pathway(
            "B.Tech",
            "Civil Engineer",
            "Career",
            "Civil engineers plan, design and supervise infrastructure such as buildings, roads, bridges, water systems and other construction projects.",
            "Career entry after undergraduate study",
            "Relevant civil engineering education and applicable professional or recruitment requirements.",
            "Structural fundamentals, AutoCAD, surveying, project management, problem solving and communication",
            "Construction companies, infrastructure firms, consulting, government projects and real estate",
            "M.Tech, structural engineering, transportation engineering, environmental engineering and management",
            "Civil Engineer, Structural Engineer, Site Engineer, Project Engineer",
            "Recruitment examinations and organization-specific selection processes",
            "Engineering colleges and universities offering civil engineering programs",
            "Infrastructure development creates opportunities across construction, transportation and public works."
    );
    pathwayRepository.save(p17);


    Pathway p18 = new Pathway(
            "B.Tech",
            "Data Scientist",
            "Career",
            "Data scientists use statistics, programming and machine learning techniques to extract useful insights from data and support decision making.",
            "Career entry after relevant education and skill development",
            "Relevant technical education or strong equivalent skills in programming, statistics and data analysis.",
            "Python, SQL, statistics, machine learning, data visualization, mathematics and problem solving",
            "Technology, finance, healthcare, retail, consulting, research and analytics",
            "M.Tech, MS, specialized data science programs and advanced certifications",
            "Data Scientist, Data Analyst, ML Engineer, Business Intelligence Analyst",
            "Usually employer-specific technical assessments and interviews",
            "Engineering and science institutions offering computer science, statistics and data-related programs",
            "Data-driven decision making is expanding across many industries, creating opportunities for analytics professionals."
    );
    pathwayRepository.save(p18);


    Pathway p19 = new Pathway(
            "MBBS",
            "Doctor",
            "Career",
            "Doctors diagnose, treat and manage health conditions while working with patients across hospitals, clinics and other healthcare settings.",
            "Career after MBBS and required registration",
            "MBBS qualification and applicable professional registration requirements.",
            "Clinical knowledge, communication, diagnosis, patient care, decision making and empathy",
            "Hospitals, clinics, public health, research, medical education and healthcare organizations",
            "MD, MS, super-specialization, public health and medical research",
            "General Physician, Medical Officer and specialized medical roles after further study",
            "NEET PG and other applicable postgraduate medical admission routes",
            "Medical colleges, teaching hospitals and healthcare institutions",
            "Medicine offers multiple long-term paths through clinical practice, specialization, research and public health."
    );
    pathwayRepository.save(p19);


    Pathway p20 = new Pathway(
            "B.Pharm",
            "Pharmacist",
            "Career",
            "Pharmacists work with medicines and support their safe and appropriate use in healthcare and pharmaceutical settings.",
            "Career entry after relevant qualification and applicable requirements",
            "B.Pharm or relevant qualification and applicable professional registration requirements.",
            "Pharmacology, medicine knowledge, communication, accuracy and patient-support skills",
            "Hospitals, pharmacies, pharmaceutical companies, quality control and regulatory organizations",
            "M.Pharm, Pharm.D, MBA and pharmaceutical research",
            "Pharmacist, Quality Analyst, Clinical Research Associate, Regulatory Affairs professional",
            "Organization-specific recruitment and applicable professional requirements",
            "Pharmacy colleges, universities and pharmaceutical institutions",
            "Pharmacy careers extend across healthcare services, pharmaceutical manufacturing and research."
    );
    pathwayRepository.save(p20);


    Pathway p21 = new Pathway(
            "BBA",
            "Business Analyst",
            "Career",
            "Business analysts study business requirements, processes and data to help organizations make better decisions and improve operations.",
            "Career entry after relevant education and skill development",
            "A business, management, commerce or technical background with relevant analytical skills can be useful.",
            "Excel, SQL, data analysis, communication, problem solving, business understanding and presentation",
            "IT, banking, consulting, healthcare, retail, finance and other business sectors",
            "MBA, business analytics programs and professional certifications",
            "Business Analyst, Business Intelligence Analyst, Process Analyst, Management Analyst",
            "Recruitment commonly involves aptitude, analytical and interview-based selection processes",
            "Universities, management colleges and institutions offering business or analytics programs",
            "Business analysis combines business understanding with analytical and communication skills and can lead to roles across industries."
    );
    pathwayRepository.save(p21);


    System.out.println("Pathway data inserted successfully!");
}
    }

    // -------------------------------------------------
    // 8. FIND FIELD BY NAME
    // -------------------------------------------------

    private Field getField(String name) {

        return fieldRepository.findAll()
                .stream()
                .filter(field -> field.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
    private void saveCourseIfMissing(
        String name,
        String description,
        String duration,
        String eligibility,
        Field field) {

    if (!courseRepository.existsByName(name)) {

        Course course = new Course(
                name,
                description,
                duration,
                eligibility
        );

        course.setField(field);
        courseRepository.save(course);
    }
}
}