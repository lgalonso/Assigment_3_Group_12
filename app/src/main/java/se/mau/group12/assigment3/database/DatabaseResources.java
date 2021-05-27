package se.mau.group12.assigment3.database;

import android.content.Context;

public class DatabaseResources {
    //Todo adapt the videos so they match images
//    private String[] video_ids = {"uUKAYkQZXko", "-d-fF1Nx2bQ", "HgJ2tFT-au0", "UBMk30rjy0o", "W273f7MYt2Y"};
    private String[] video_ids = {"uUKAYkQZXko", "-d-fF1Nx2bQ", "UBMk30rjy0o", "W273f7MYt2Y"};
    private String[] training_names = {"Abs workout", "Legs Workout", "Full Body workout", "Shoulders and back workout"};
    private String[] training_descriptions = {"Get ready for one of the best Home Ab Workouts of your LIFE! Let's do this! An ABS workout that you can do whenever and wherever you like!! You don't need any equipment or weight.",
            "Learn How to Hit Every Muscle in your arms by combining calisthenics and dumbbells to get some insane results from this workout.",
            "No Equipment necessary and not much space needed. If you need more breaks - TAKE THEM! Don't worry too much about that. You will improve over time :) that's the best feeling! ",
            "This powerful low impact workout is all about building strength and sculpting out the chest, back and shoulders using dumbbells only and with no jumping. Three different upper body supersets to get through today loaded with effective chest and back exercises and movements that will set those shoulders on fire oww oww! Keep your reps slow and controlled and adjust your weights or take breaks as needed to make sure you maintain proper form. Let's do this! "};
    private int[] training_difficulty = {2, 2, 3, 4};
    private int[] training_duration = {10, 20, 20, 30};
    private String[] abs_name = {"Scissor Kicks", "Lying Leg Raise", "Plank Static Holds"};
    private String[] abs_description = {"Keep hands under bum, alternate kicks vertically.",
    "Raise legs vertically and hit up at the top", "Keep glutes and abs contracted"};
    private int[] abs_difficulty = {2, 2, 3};
    private int[] abs_duration = {3, 6, 4};
    private int[] abs_timestamps = {12, 42, 467};
    private String[] abs_images = {"push_up", "sit_up", "t_cross_sit_up"};

//    private String[] arms_name = {"Bicep Curl 21's", "Hammer Curls", "Rear Delt Flyes", "Tricep Kick Backs"};
//    private String[] arms_description = {"Raise and lower forearms.",
//            "Raise and lower forearms.", "Raise and lower forearms rotated 90 degrees.", "Lower back, keep biceps static and move forearms vertically"};
//    private int[] arms_difficulty = {2, 4, 3, 4};
//    private int[] arms_duration = {2, 2, 5, 5};
//    private int[] arms_timestamps = {236, 310, 359, 463};
//    private String[] arms_images = {"", "", "", ""};

    private String[] legs_name = {"Side to Side Jump Squats", "Explosive Assisted Pistol Squats", "Step Ups"};
    private String[] legs_description = {"Jump to side and squat on landing.",
            "Sit on bench, rise and jump with one leg.", "Step up and raise opposite leg."};
    private int[] legs_difficulty = {2, 4, 3};
    private int[] legs_duration = {3, 2, 5};
    private int[] legs_timestamps = {99, 134, 155};
    private String[] legs_images = {"leg_lift", "lunge", "squat"};

    private String[] full_body_name = {"Squat Jumps", "Lay Down-Push Up", "1 Leg Glute Bridge"};
    private String[] full_body_description = {"Squat down and jump up.",
            "Lay on your chest then push up.", "Raise glute, keep shoulders down and extend one leg."};
    private int[] full_body_difficulty = {2, 4, 3};
    private int[] full_body_duration = {2, 2, 2};
    private int[] full_body_timestamps = {11, 431, 851};
    private String[] full_body_images = {"bike", "lunge_with_dumbbell", "treadmill"};

    private String[] shoulders_back_name = {"Underhand Row", "Rear Flys", "Lumbar Extensions"};
    private String[] shoulders_back_description = {"Lower back and pull arms back.",
            "Lower back and extend arms horizantly.", "Lay on chest and rise arms and legs."};
    private int[] shoulders_back_difficulty = {2, 4, 3};
    private int[] shoulders_back_duration = {2, 2, 4};
    private int[] shoulders_back_timestamps = {460, 580, 1688};
    private String[] shoulders_back_images = {"back_on_swiss_ball", "pull_up", "vinst_on_swiss_ball"};

    private int[] exercise_interval = {1, 2, 3};

    public void loadResources(Context context) {
        AppDatabase db = AppDatabase.getInstance(context);
        ExerciseDao exerciseDao = db.exerciseDao();
        TrainingDao trainingDao = db.trainingDao();

        Training training = new Training();
        Exercise exercise = new Exercise();

        for (int i = 0; i < video_ids.length; i++) {
            training.setName(training_names[i]);
            training.setDescription(training_descriptions[i]);
            training.setDifficulty(training_difficulty[i]);
            training.setDuration(training_duration[i]);

            switch (i){
                case 0:
                    for (int j = 0; j < 2; j++) {
                        exercise.setName(abs_name[j]);
                        exercise.setDescription(abs_description[j]);
                        exercise.setDifficulty(abs_difficulty[j]);
                        exercise.setDuration(abs_duration[j]);
                        exercise.setVideo_id(video_ids[i]);
                        exercise.setImage(abs_images[j]);
                        exercise.setVideo_timestamp(abs_timestamps[j]);
                        exercise.setDate_interval(exercise_interval[j]);
                        switch (j){
                            case 0:
                                training.setExercise_key_1(abs_name[j]);
                                break;
                            case 1:
                                training.setExercise_key_2(abs_name[j]);
                                break;
                            case 2:
                                training.setExercise_key_3(abs_name[j]);
                                break;
                            default:
                                break;
                        }
                        exerciseDao.insert(exercise);
                    }
                    break;
                case 1:
                    for (int j = 0; j < 2; j++) {
                        exercise.setName(legs_name[j]);
                        exercise.setDescription(legs_description[j]);
                        exercise.setDifficulty(legs_difficulty[j]);
                        exercise.setDuration(legs_duration[j]);
                        exercise.setVideo_id(video_ids[i]);
                        exercise.setImage(legs_images[j]);
                        exercise.setVideo_timestamp(legs_timestamps[j]);
                        exercise.setDate_interval(exercise_interval[j]);
                        switch (j){
                            case 0:
                                training.setExercise_key_1(legs_name[j]);
                                break;
                            case 1:
                                training.setExercise_key_2(legs_name[j]);
                                break;
                            case 2:
                                training.setExercise_key_3(legs_name[j]);
                                break;
                            default:
                                break;
                        }
                        exerciseDao.insert(exercise);
                    }
                    break;
                case 2:
                    for (int j = 0; j < 2; j++) {
                        exercise.setName(full_body_name[j]);
                        exercise.setDescription(full_body_description[j]);
                        exercise.setDifficulty(full_body_difficulty[j]);
                        exercise.setDuration(full_body_duration[j]);
                        exercise.setVideo_id(video_ids[i]);
                        exercise.setImage(full_body_images[j]);
                        exercise.setVideo_timestamp(full_body_timestamps[j]);
                        exercise.setDate_interval(exercise_interval[j]);
                        switch (j){
                            case 0:
                                training.setExercise_key_1(full_body_name[j]);
                                break;
                            case 1:
                                training.setExercise_key_2(full_body_name[j]);
                                break;
                            case 2:
                                training.setExercise_key_3(full_body_name[j]);
                                break;
                            default:
                                break;
                        }
                        exerciseDao.insert(exercise);
                    }
                    break;
                case 3:
                    for (int j = 0; j < 2; j++) {
                        exercise.setName(shoulders_back_name[j]);
                        exercise.setDescription(shoulders_back_description[j]);
                        exercise.setDifficulty(shoulders_back_difficulty[j]);
                        exercise.setDuration(shoulders_back_duration[j]);
                        exercise.setVideo_id(video_ids[i]);
                        exercise.setImage(shoulders_back_images[j]);
                        exercise.setVideo_timestamp(shoulders_back_timestamps[j]);
                        exercise.setDate_interval(exercise_interval[j]);
                        switch (j){
                            case 0:
                                training.setExercise_key_1(shoulders_back_name[j]);
                                break;
                            case 1:
                                training.setExercise_key_2(shoulders_back_name[j]);
                                break;
                            case 2:
                                training.setExercise_key_3(shoulders_back_name[j]);
                                break;
                            default:
                                break;
                        }
                        exerciseDao.insert(exercise);
                    }
                    break;
                default:
                    break;
            }

            trainingDao.insert(training);
        }
    }
}
