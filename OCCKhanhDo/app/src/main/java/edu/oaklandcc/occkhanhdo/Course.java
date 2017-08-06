package edu.oaklandcc.occkhanhdo;

/**
 * The Course class is a program that was provided by the college as a starting point for the
 * Android application assignment.
 * @author Oakland Community College
 * @version November 2016
 * CIS 2818
 */

public class Course {
    private String name;
    private String title;
    private String description;
    private boolean taken;

    public static Course [] courses = {
            new Course("CIS 1400", "Web Design 1", "This course focuses on the fundamentals of web site content development. Students will be introduced to the fundamental HTML5 structure of a webpage and then proceed to creating pages using a professional web editing tool. Students will create a fully functional original website using the web design editing tool that has elements such as images, hyperlinks, cascading style sheets for formatting, tables and integration of certain multimedia elements such as sound files, videos and Flash objects. Discussions will include accessibility of the design, overall site maintenance and publishing using FTP technologies. Students taking this course should have working knowledge of Windows and basic knowledge of the Internet. ", false),
            new Course("CIS 1500", "Introduction to Programming (Java)", "Students should have elementary Algebra skills and be familiar with both elementary word processing and Windows file management techniques prior to enrolling in this class. Students will be introduced to the fundamental techniques and syntax for understanding, designing, constructing, debugging, and testing object-oriented programs by studying the Java programming language. The structured programming basics of process, selection and iteration will be covered as well as primitive and complex data typing, methods, parameters and input/output. The basics of graphical user interface (GUI) programming such as event handling, windows and widgets will be introduced. Fundamental object-oriented concepts of classes, methods, abstraction, encapsulation and inheritance will also be introduced. Students will be required to complete computer-based assignments inside/outside of class.", false),
            new Course("CIS 2818", "Wireless Handheld Application Development", "This course focuses on the design and implementation of wireless handheld application software for business and personal use. Students will use software development kits (SDKs) from popular handheld manufacturers (e.g., Apple, Motorola, BlackBerry) to develop and test application software. Development techniques will focus on operational aspects of handheld devices that distinguish them from PCs and general computing platforms. Students will be required to complete computer based assignments inside and outside of class.", false),
            new Course("ART 1530", "Acrylic Painting", "The student will develop an understanding of acrylic painting medium by exploring a multi-media approach to painting. Students will demonstrate competency in handling figurative and non-figurative subjects, montage, collage, impasto build-up, and other related technical problems.", false),
            new Course("CUL 1250", "Pastry I", "The student will learn to produce contemporary pastries that would appear on the menus of finer restaurants. Emphasis is placed on preparation of petit fours and French pastry, puff pastry and pate choux specialties, gateaus and tortes, ice cream, and includes an introduction to plated desserts.", false)
    };

    public Course(String name, String title, String description, boolean taken) {
        this.name = name;
        this.title = title;
        this.description = description;
        this.taken = taken;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isTaken() {
        return taken;
    }

    public void setTaken(boolean taken) {
        this.taken = taken;
    }

    @Override
    public String toString() {
        return name;
    }
}
